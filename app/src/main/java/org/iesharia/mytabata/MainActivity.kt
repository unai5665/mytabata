package org.iesharia.mytabata

import android.os.Bundle
import android.os.CountDownTimer
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.iesharia.mytabata.ui.theme.MytabataTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MytabataTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Counter(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Counter(modifier: Modifier = Modifier) {
    var theCounter by remember { mutableStateOf(0L) }
    val miCounterDown = remember{CounterDown(99) { newvalue -> theCounter = newvalue}}
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentWidth(Alignment.CenterHorizontally)
            .padding(top = 400.dp)
    ){
        Row {
            Button(
                onClick = {

                },
                modifier = Modifier.padding(8.dp)
            ) {
                Text(text = "<")
            }
            Text(
                text = "00:00:00",
                modifier = Modifier.padding(top = 20.dp, start = 10.dp, end = 10.dp)
            )
            Button(
                onClick = {

                },
                modifier = Modifier.padding(8.dp)
            ) {
                Text(text = ">")
            }
        }

    }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentWidth(Alignment.CenterHorizontally)
    ) {
        Text(
            text = theCounter.toString(),
            modifier = Modifier.align(Alignment.CenterHorizontally)

        )
        Button(onClick = {
            miCounterDown.toggle()
        }) {
            Text(
                text = "Iniciar"
            )
        }
    }
}


