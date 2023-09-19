package naver.next.aiemotion.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun HomeScreen(navController: NavController) {

    var textFieldState by remember { mutableStateOf("") }

    Box(modifier = Modifier.fillMaxSize()) {
        OutlinedTextField(
            modifier = Modifier.padding(top = 12.dp, start = 12.dp),
            value = textFieldState,
            onValueChange = { text: String -> textFieldState = text },
        )
    }
}