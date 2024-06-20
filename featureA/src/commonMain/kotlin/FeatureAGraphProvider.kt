import androidx.compose.runtime.Composable
import navigation.screens.FeatureAScreens
import navigation.screens.MainScreens
import navigation.screens.Screen

@Composable
fun Screen.RegisterFeatureAGraphProvider() {
    when (this) {
        is FeatureAScreens.HomeAScreen -> HomeA(this.componentContext)
    }
}