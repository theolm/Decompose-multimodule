package navigation

import com.arkivanov.decompose.ComponentContext
import navigation.configuration.Configuration
import navigation.configuration.MainConfig
import navigation.screens.MainScreens

fun Configuration.toScreen(componentContext: ComponentContext) =
    when(this) {
        MainConfig.Home -> MainScreens.HomeScreen(componentContext)
        MainConfig.ThumbsUp -> MainScreens.ThumbsUpScreen(componentContext)
    }
