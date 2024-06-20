package navigation.screens

import com.arkivanov.decompose.ComponentContext
import kotlinx.serialization.Serializable

object MainScreens {
    @Serializable
    data class HomeScreen(val componentContext: ComponentContext) : Screen()

    @Serializable
    data class ThumbsUpScreen(val componentContext: ComponentContext) : Screen()
}