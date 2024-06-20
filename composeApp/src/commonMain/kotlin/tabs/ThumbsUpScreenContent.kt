package tabs

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.ComponentContext

@Composable
internal fun ThumbsUpContent(componentContext: ComponentContext) {
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
        }
    }
}