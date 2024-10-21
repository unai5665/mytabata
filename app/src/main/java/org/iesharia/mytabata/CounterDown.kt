package org.iesharia.mytabata

import android.os.CountDownTimer
import android.util.Log

class CounterDown(private var segundos: Int, private var loquehacealhacertick: (Long) -> Unit) {
    private var counterState: Boolean = false
    private var currentTimer: CountDownTimer? = null
    private var remainingTime: Long = segundos * 1000L

    private fun createTimer(timeInMillis: Long) {
        currentTimer = object : CountDownTimer(timeInMillis, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                if (counterState) {
                    remainingTime = millisUntilFinished
                    loquehacealhacertick(millisUntilFinished / 1000)
                }
            }

            override fun onFinish() {
                counterState = false
                Log.i("dam2", "Timer finished")
            }
        }
    }

    fun toggle() {
        Log.i("dam2", "toggle: $counterState")
        if (counterState) {
            pause()
        } else {
            start()
        }
    }

    fun start() {
        Log.i("dam2", "Starting timer")
        if (!counterState) {
            counterState = true
            createTimer(remainingTime)
            currentTimer?.start()
        }
    }

    fun pause() {
        Log.i("dam2", "Pausing timer")
        if (counterState) {
            counterState = false
            currentTimer?.cancel()
        }
    }

    fun reset(newTimeInSeconds: Int) {
        Log.i("dam2", "Resetting timer")
        currentTimer?.cancel()
        segundos = newTimeInSeconds
        remainingTime = newTimeInSeconds * 1000L
        counterState = false
        loquehacealhacertick(newTimeInSeconds.toLong()) 
    }
}
