package com.example.radiobuttoncomposable

import android.os.Bundle
import androidx.compose.runtime.*
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.radiobuttoncomposable.ui.theme.RadioButtonComposableTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RadioButtonComposableTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MyUI()
                }
            }
        }
    }
}

@Composable
fun MyUI(){
    val context = LocalContext.current
    val radioOptions = listOf<String>("Pizza", "Meat","Fish")
    var  (selectedItem,onOptionSelected) = remember{
        mutableStateOf(radioOptions[0])
    }
    // Grouping the radio buttons in one group
    Column(modifier = Modifier.selectableGroup()) {
        radioOptions.forEach{label ->
            Row(modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .selectable(
                    selected = (selectedItem == label),
                    onClick = { onOptionSelected(label)},
                    role = Role.RadioButton
                )
                .padding(horizontal = 16.dp)
            ) {

                RadioButton(
                    modifier = Modifier.padding(end = 16.dp),
                    onClick = {onOptionSelected(label)},
                    selected = (selectedItem == label)
                )
                Text(text = label)

            }
        }
    }
}

