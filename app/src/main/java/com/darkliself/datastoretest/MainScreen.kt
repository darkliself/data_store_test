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
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

@Composable
fun MainScreen(context: Context) {
    val EXAMPLE_COUNTER = stringPreferencesKey("lolwhat")

    val t = NicknamePreferenceRepo()

    class MyViewModel : ViewModel() {
        init {
            viewModelScope.launch {
                // Coroutine that will be canceled when the ViewModel is cleared.
                t.write(context, "lolwhat")
                println(t.showFullData(context, EXAMPLE_COUNTER))
            }
        }

        fun All() {
        }
    }

    val z = MyViewModel()


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

        Button(onClick = {

        }) {
            Text("To Do")
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
    MainScreen(LocalContext.current)
}


