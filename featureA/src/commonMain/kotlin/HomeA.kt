import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.bringToFront
import com.arkivanov.decompose.router.stack.push
import navigation.LocalNavigator
import navigation.configuration.FeatureAConfig
import navigation.configuration.FeatureBConfig

@Composable
internal fun HomeA(componentContext: ComponentContext) {
    val navigator = LocalNavigator.current
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = {
                    Text("Feature A Home")
                }
            )
        }
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            Text("Feature A Home")
            Button(
                onClick = {
                    navigator?.apply {
                        navigation.bringToFront(FeatureBConfig.HomeB)
                    }
                }
            ) {
                Text("Go to B Home")
            }
        }
    }
}