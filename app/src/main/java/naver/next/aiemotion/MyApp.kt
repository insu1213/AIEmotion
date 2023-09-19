package naver.next.aiemotion

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation

import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import naver.next.aiemotion.screen.DetailScreen
import naver.next.aiemotion.screen.GraphScreen
import naver.next.aiemotion.screen.HomeScreen
import naver.next.aiemotion.screen.MainScreen
import naver.next.aiemotion.screen.SplashScreen
import naver.next.aiemotion.ui.theme.AIEmotionTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyApp() {
    AIEmotionTheme() {
        val navController = rememberNavController()

        NavHost(navController = navController, startDestination = "SplashScreen") {
            composable("SplashScreen") {
                SplashScreen(
                    onNavigateToMain = { navController.navigate("MainScreen") }
                )
            }
            composable("MainScreen") {
                MainScreen(
                )
            }

//            navigation(startDestination = "HomeScreen", route = "main") {
//                composable("HomeScreen") {
//                    HomeScreen()
//                }
//                composable("GraphScreen") {
//                    GraphScreen()
//                }
//            }

            composable(
                route = "DetailScreen/{postId}",
                arguments = listOf(navArgument("postId") { type = NavType.StringType })
            ) {
                DetailScreen(

                )
            }
        }
    }
}