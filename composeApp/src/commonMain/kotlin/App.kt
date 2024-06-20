import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import com.arkivanov.decompose.ComponentContext
import navigation.RootNavigation
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App(componentContext: ComponentContext) {
    MaterialTheme {
        RootNavigation(componentContext)
    }
}
