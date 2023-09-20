package naver.next.aiemotion.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import naver.next.aiemotion.Graph

@Composable
fun GraphScreen(navController: NavController) {
    Box(modifier = Modifier.fillMaxSize()) {
        Graph()
    }
}