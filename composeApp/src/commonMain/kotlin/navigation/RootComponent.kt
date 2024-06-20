package navigation

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.value.Value
import kotlinx.serialization.Serializable
import navigation.configuration.Configuration
import navigation.configuration.MainConfig
import navigation.screens.MainScreens
import navigation.screens.Screen

internal class RootComponent(
    componentContext: ComponentContext,
) : ComponentContext by componentContext {
    val navigation = StackNavigation<Configuration>()

    val screenStack: Value<ChildStack<*, Screen>> = childStack(
        source = navigation,
        serializer = Configuration.serializer(),
        initialStack = {
            listOf(MainConfig.Home)
        },
        handleBackButton = true,
        childFactory = ::createChild
    )

    private fun createChild(
        configuration: Configuration,
        componentContext: ComponentContext
    ): Screen = configuration.toScreen(componentContext)

}

