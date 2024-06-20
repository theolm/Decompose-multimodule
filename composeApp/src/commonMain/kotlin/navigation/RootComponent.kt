package navigation

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.value.Value
import kotlinx.serialization.Serializable

internal class RootComponent(
    componentContext: ComponentContext,
) : ComponentContext by componentContext {
    val navigation = StackNavigation<NavConfig>()

    val screenStack: Value<ChildStack<*, NavScreen>> = childStack(
        source = navigation,
        serializer = NavConfig.serializer(),
        initialStack = {
            listOf(MainConfig.Home)
        },
        handleBackButton = true,
        childFactory = ::createChild
    )

    private fun createChild(
        configuration: NavConfig,
        componentContext: ComponentContext
    ): NavScreen = when (configuration) {
        is MainConfig.Home -> HomeScreen(componentContext)
        is MainConfig.ThumbsUp -> ThumbsUpScreen(componentContext)
    }

}

@Serializable
sealed class NavConfig

@Serializable
open class NavScreen

@Serializable
sealed class MainConfig : NavConfig() {
    @Serializable
    data object Home : MainConfig()
    data object ThumbsUp : MainConfig()
}


@Serializable
data class HomeScreen(val componentContext: ComponentContext) : NavScreen()
data class ThumbsUpScreen(val componentContext: ComponentContext) : NavScreen()
