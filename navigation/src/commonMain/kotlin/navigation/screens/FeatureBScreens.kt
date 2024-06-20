package navigation.screens

import com.arkivanov.decompose.ComponentContext
import kotlinx.serialization.Serializable

object FeatureBScreens {
    @Serializable
    data class HomeBScreen(val componentContext: ComponentContext) : Screen()

    @Serializable
    data class EndScreen(val componentContext: ComponentContext) : Screen()
}