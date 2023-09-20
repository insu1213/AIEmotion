package naver.next.aiemotion.screen

import android.content.ContentValues.TAG
import android.content.Context
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import kotlinx.coroutines.launch
import naver.next.aiemotion.Confidence
import naver.next.aiemotion.EmotionBody
import naver.next.aiemotion.RetrofitAPI
import naver.next.aiemotion.RetrofitClient.service
import naver.next.aiemotion.entity.Diary
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val coroutine = rememberCoroutineScope()
    var textFieldState by remember { mutableStateOf("") }
    val ctx = LocalContext.current
    var response = remember { mutableStateOf("") }
    var confidenceState by remember { mutableStateOf(Confidence(0.0, 0.0, 0.0)) }

    Box(modifier = Modifier.fillMaxSize()) {
        Column() {
            OutlinedTextField(
                placeholder = { Text(text = "일기를 입력하세요.") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp, start = 12.dp, end = 12.dp),
                value = textFieldState,
                onValueChange = { text: String -> textFieldState = text },
                minLines = 5,

            )
            Box(modifier = Modifier.fillMaxWidth()) {
                Button(
                    modifier = Modifier
                        .align(Alignment.CenterEnd)
                        .padding(top = 12.dp, end = 12.dp),
                    onClick = {
                        Log.d(TAG, "실행됨")
                        if(textFieldState.isNotEmpty()) {
                            coroutine.launch {
                                val data = service.postData(EmotionBody(textFieldState)).body()
                                confidenceState = data!!.document.confidence
                                Log.d(TAG, "HomeScreen: $confidenceState")
                                val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")
                                val current = LocalDateTime.now().format(formatter)

                                val diary = Diary(
                                    content = textFieldState,
                                    date = current,
                                    confidence = "${confidenceState.negative}, ${confidenceState.neutral}, ${confidenceState.positive}"
                                )
                                viewModel.addDiary(diary)
                            }
                        }
                    }
                ) {
                    Text(
                        text = "분석",
                        modifier = Modifier.padding(4.dp),
                        fontSize = 14.sp
                    )
                }
            }

            Text(
                text = "negative: ${confidenceState.negative}" +
                    "\nneutral: ${confidenceState.neutral}" +
                    "\npositive: ${confidenceState.positive}",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold, modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth(),
                textAlign = TextAlign.Center
            )
        }

    }
}
