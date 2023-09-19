package naver.next.aiemotion

import androidx.annotation.StringRes
import naver.next.aiemotion.R.string as AppText
import naver.next.aiemotion.R.drawable as AppIcon


sealed class Screen(val route: String, val iconId: Int, @StringRes val resourceId: Int) {
    object Home : Screen("HomeScreen", AppIcon.ic_home, AppText.home)
    object Graph : Screen("GraphScreen", AppIcon.ic_graph, AppText.graph)
}