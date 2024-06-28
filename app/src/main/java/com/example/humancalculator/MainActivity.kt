package com.example.humancalculator

import android.inputmethodservice.Keyboard
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.util.rangeTo
import com.example.humancalculator.ui.theme.HumanCalculatorTheme
import org.w3c.dom.Text

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HumanCalculatorTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LabCalculator("My Lab180")
                }
            }
        }
    }
}
@Composable
fun LabCalculator(name: String)
{

        var Computers : String by remember { mutableStateOf("") }
        var keyboards : String by remember { mutableStateOf("") }
        var Screens : String by remember { mutableStateOf("") }
        var TotalValue : String by remember { mutableStateOf("") }
    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)

        ){

        OutlinedTextField(value = Computers,
            onValueChange = {Computers = it},
             label = { Text("Number of Computer")},
            keyboardOptions =  KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        OutlinedTextField(value = keyboards,
            onValueChange = {keyboards = it},
            label = { Text(text = "Number of keyboard") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        OutlinedTextField(value = Screens,
            onValueChange = {Screens = it},
            label = { Text(text = "Number of Screens") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        Button(onClick = {
            var ComputerValue = Computers.toIntOrNull()?: 0
            var keyboardsValue = keyboards.toIntOrNull()?: 0
            var ScreensValue = Screens.toIntOrNull()?: 0
            var total = ComputerValue * 5000 + keyboardsValue * 2000 + ScreensValue * 200

            TotalValue ="The total of all $name price is R:$total"

        }) {

            Text(text = "Calculate the Total")

        }
        Text(TotalValue,
            style = MaterialTheme.typography.bodyMedium)
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    HumanCalculatorTheme {
        LabCalculator("My Lab180")
    }
}