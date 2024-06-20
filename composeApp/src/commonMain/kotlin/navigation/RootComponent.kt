package navigation

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.StackAnimation
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.fade
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.slide
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.stackAnimation
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.active
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.value.Value
import navigation.configuration.Configuration
import navigation.configuration.MainConfig
import navigation.screens.MainScreens
import navigation.screens.Screen

internal class RootComponent(
    componentContext: ComponentContext,
) : ComponentContext by componentContext {
    private val navigation = StackNavigation<Configuration>()
    val navigator = Navigator(navigation)

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

fun ChildStack<*, Screen>.isTab() : Boolean {
    val active = this.active.instance
    return active is MainScreens.HomeScreen  || active is MainScreens.ThumbsUpScreen
}

fun ChildStack<*, Screen>.getAnimation() : StackAnimation<Any, Screen> {
    return if (isTab()) {
        stackAnimation(fade())
    } else {
        stackAnimation(slide())
    }
}