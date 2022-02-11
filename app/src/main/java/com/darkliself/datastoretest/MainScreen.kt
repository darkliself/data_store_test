package com.darkliself.datastoretest


import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.datastore.core.DataStore
import androidx.datastore.dataStoreFile
import java.util.prefs.Preferences



@Composable
fun MainScreen() {
    var key by remember { mutableStateOf("") }
    var value by remember { mutableStateOf("") }
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Box(
            Modifier
                .fillMaxWidth(0.8f)
                .background(MaterialTheme.colors.onSurface.copy(alpha = 0.12f)),
        ) {
            Column(
            ) {
                Text("Enter key")
                BasicTextField(
                    modifier = Modifier.fillMaxWidth(0.8f),
                    value = key, onValueChange = {
                        key = it
                    })
            }
        }
        Box(
            Modifier
                .fillMaxWidth(0.8f)
                .background(MaterialTheme.colors.onSurface.copy(alpha = 0.12f)),
        ) {
            Column(
            ) {
                Text("Enter value")

                BasicTextField(
                    modifier = Modifier.fillMaxWidth(0.8f),
                    value = value, onValueChange = {
                        value = it
                    })
            }
        }

        Button(
            onClick = { /*TODO*/ }) {
            Text("SAVE")
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {
    MainScreen()
}

fun Data(context: Context) {

}


