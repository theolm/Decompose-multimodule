package tabs

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.bringToFront
import navigation.LocalNavigator
import navigation.configuration.FeatureAConfig

@Composable
internal fun ThumbsUpContent(componentContext: ComponentContext) {
    val navigator = LocalNavigator.current
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = {
                    Text("ThumbsUp screen")
                }
            )
        }
    ) {
        Box(Modifier.fillMaxSize()) {
            Text("ThumbsUp")

            Button(
                onClick = {
                    navigator?.apply {
                        navigation.bringToFront(FeatureAConfig.HomeA)
                    }
                }
            ) {
                Text("Go to Feature A Home")
            }
        }
    }
}