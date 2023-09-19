package naver.next.aiemotion

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

@Composable
fun BottomNavigationComposable(navController: NavController) {
    val items = listOf(
        Screen.Home,
        Screen.Graph,
    )


    BottomNavigation (
        backgroundColor = colorResource(R.color.white),
        contentColor = Color.Black,
        modifier = Modifier
            .padding(bottom = 12.dp, start = 8.dp, end = 8.dp)
            .graphicsLayer {
                clip = true
                shape = RoundedCornerShape(15.dp)
                shadowElevation = 20f
            },
        elevation = 20.dp
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination

        items.forEach { item ->
            BottomNavigationItem(
                modifier = Modifier,
                icon = {
                    Icon(
                        painterResource(item.iconId),
                        contentDescription = stringResource(item.resourceId),
                        modifier = Modifier.size(24.dp)
                    )
                },
                //label = { Text(text = item.title, fontSize = 9.sp) },
                selectedContentColor = colorResource(R.color.teal_200),
                unselectedContentColor = colorResource(R.color.purple_700),
                alwaysShowLabel = true,
                selected = currentDestination?.hierarchy?.any { it.route == item.route } == true,
                onClick = {
                    navController.navigate(item.route) {
                        navController.graph.startDestinationRoute?.let { screen_route ->
                            popUpTo(screen_route) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
            )
        }
    }
}