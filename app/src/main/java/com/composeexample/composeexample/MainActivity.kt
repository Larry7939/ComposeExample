package com.composeexample.composeexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.composeexample.composeexample.ui.theme.ComposeExampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeExampleTheme {
                var selected by remember { mutableStateOf(false) }
                Column(Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center) {
                    Checkbox(
                        checked = selected,
                        onCheckedChange = { selected = it }
                    )
//                    ContactsList(
//                        isLoading = false,
//                        names = listOf("Peter")
//                    )
                    ContactsList(
                        ContactsListState(
                            isLoading = false,
                            names = listOf("Peter")
                        )
                    )
                }
            }
        }
    }
}

//@Composable
//fun ContactsList(
//    isLoading: ContactsListState = false,
//    names: List<String>
//) {
//    Box(
//        contentAlignment = Alignment.Center
//    ) {
//        if (isLoading) {
//            CircularProgressIndicator()
//        } else {
//            Text(names.toString())
//        }
//    }
//}

@Composable
fun ContactsList(
    contactsListState: ContactsListState
) {
    Box(
        contentAlignment = Alignment.Center
    ) {
        if (contactsListState.isLoading) {
            CircularProgressIndicator()
        } else {
            Text(contactsListState.names.toString())
        }
    }
}

@Stable
data class ContactsListState(
    val isLoading: Boolean,
    val names: List<String>
)