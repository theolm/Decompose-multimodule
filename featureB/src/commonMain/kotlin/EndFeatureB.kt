import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.replaceAll
import navigation.LocalNavigator
import navigation.configuration.MainConfig

@Composable
internal fun EndFeatureB(componentContext: ComponentContext) {
    val navigator = LocalNavigator.current

    Scaffold {
        Button(
            onClick = {
                navigator?.apply {
                    navigation.replaceAll(MainConfig.Home)
                }
            }
        ) {
            Text("FINISH & Go to Home")
        }
    }
}