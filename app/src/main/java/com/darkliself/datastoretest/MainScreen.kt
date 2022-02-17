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
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.lifecycle.*
import androidx.lifecycle.viewmodel.compose.viewModel
import com.darkliself.datastoretest.repository.NicknameRepository
import com.darkliself.datastoretest.viewmodel.NicknameViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.launch



@Composable
fun MainScreen(context: Context,
//    viewModel: NicknameViewModel = viewModel(
//        factory = DataStoreViewModelFactory(NicknameRepository(LocalContext.current))
//    )
) {
    val EXAMPLE_COUNTER = stringPreferencesKey("lolwhat")

    val zz = NicknameViewModel(NicknameRepository(context))
    val scope = rememberCoroutineScope()

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
            scope.async {
                println("dsdsf")
            }
            scope.launch {
                zz.read("lolwhat")
            }

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
            onClick = {
                scope.launch {
                    zz.printAll()
                }
            }) {
            Text("SAVE")
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {
    MainScreen(LocalContext.current)
}

class DataStoreViewModelFactory(private val dataStorePreferenceRepository: NicknameRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(NicknameViewModel::class.java)) {
            return NicknameViewModel(dataStorePreferenceRepository) as T
        }
        throw IllegalStateException()
    }
}

