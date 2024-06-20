import androidx.compose.runtime.Composable
import navigation.screens.FeatureBScreens
import navigation.screens.Screen

@Composable
fun Screen.RegisterFeatureBGraphProvider() {
    when (this) {
        is FeatureBScreens.HomeBScreen -> HomeB(this.componentContext)
        is FeatureBScreens.EndScreen -> EndFeatureB(this.componentContext)
    }
}