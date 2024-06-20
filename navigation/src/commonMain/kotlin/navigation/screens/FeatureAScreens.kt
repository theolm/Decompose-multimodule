package navigation.screens

import com.arkivanov.decompose.ComponentContext
import kotlinx.serialization.Serializable

object FeatureAScreens {
    @Serializable
    data class HomeAScreen(val componentContext: ComponentContext) : Screen()
}