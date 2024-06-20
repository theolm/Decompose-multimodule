import androidx.compose.runtime.Composable
import navigation.screens.MainScreens
import navigation.screens.Screen
import tabs.HomeScreenContent
import tabs.ThumbsUpContent

@Composable
fun Screen.RegisterMainGraphProvider() {
    when (this) {
        is MainScreens.HomeScreen -> HomeScreenContent(this.componentContext)
        is MainScreens.ThumbsUpScreen -> ThumbsUpContent(this.componentContext)
    }
}