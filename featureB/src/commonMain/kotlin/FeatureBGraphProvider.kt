import androidx.compose.runtime.Composable
import navigation.screens.FeatureAScreens
import navigation.screens.Screen

@Composable
fun Screen.RegisterFeatureBGraphProvider() {
    when (this) {
        is FeatureAScreens.HomeAScreen -> HomeB(this.componentContext)
    }
}