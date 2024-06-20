package navigation.configuration

import kotlinx.serialization.Serializable

object MainConfig {
    @Serializable
    data object Home : Configuration

    @Serializable
    data object ThumbsUp : Configuration
}
