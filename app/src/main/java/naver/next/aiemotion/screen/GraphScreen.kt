package naver.next.aiemotion.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import naver.next.aiemotion.Graph
import naver.next.aiemotion.R.color as AppColor

@Composable
fun GraphScreen(navController: NavController) {
    var daySelectState by remember { mutableIntStateOf(1) }



    Box(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp),

                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Box(
                    modifier = Modifier
                        .width(150.dp)
                        .height(44.dp)
                        .clip(shape = RoundedCornerShape(20.dp))
                        .clickable {
                            daySelectState = 1
                        }
                        .background(color = colorResource(
                            id = if(daySelectState == 1) AppColor.teal_200
                                else AppColor.white
                        )),
                ) {
                    Text(
                        modifier = Modifier.align(Alignment.Center),
                        text = "7일",
                        fontSize = 16.sp,
                        textAlign = TextAlign.Center
                    )
                }
                Box(
                    modifier = Modifier
                        .width(150.dp)
                        .height(44.dp)
                        .clip(shape = RoundedCornerShape(20.dp))
                        .clickable {
                            daySelectState = 2
                        }
                        .background(color = colorResource(
                            id = if(daySelectState == 2) AppColor.teal_200
                            else AppColor.white
                        )),
                ) {
                    Text(
                        modifier = Modifier.align(Alignment.Center),
                        text = "30일",
                        fontSize = 16.sp,
                        textAlign = TextAlign.Center
                    )
                }

            }

            Spacer(modifier = Modifier.padding(160.dp))
            Box(modifier = Modifier
                .fillMaxWidth()

            ) {
                if(daySelectState == 1) {
                    val yPoints = listOf(
                        -1000f, -0f, -1000f, -0f, -1000f, -0f, -500f
                    )
                    Graph(yPoints = yPoints)
                } else {
                    val yPoints = listOf(
                        100f, 200f, 150f, 50f, 100f,
                        70f, 90f, 110f, 100f, 200f,
                        150f, 50f, 100f, 70f, 90f,
                        110f, 115f, 110f, 50f, 55f,
                        70f, 90f, 110f, 100f, 200f,
                        150f, 50f, 100f, 70f, 90f,
                    )
                    Graph(yPoints = yPoints)
                }
            }

        }
    }

}