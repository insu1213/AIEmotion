package naver.next.aiemotion.screen

import android.graphics.Paint.Align
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay

private const val SPLASH_TIMEOUT = 1000L

@Composable
fun SplashScreen(
    onNavigateToMain: () -> Unit
) {
    Box(modifier = Modifier.fillMaxSize()) {
        Text(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(top = 24.dp),
            text = "AIEmotion",
            fontSize = 42.sp
        )

        CircularProgressIndicator(
            modifier = Modifier
                .align(Alignment.Center)
                .padding(top = 24.dp)
        )
    }

    LaunchedEffect(true) {
        delay(SPLASH_TIMEOUT)
        onNavigateToMain()
    }
}