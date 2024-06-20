package navigation

import com.arkivanov.decompose.ComponentContext
import navigation.configuration.Configuration
import navigation.configuration.FeatureAConfig
import navigation.configuration.FeatureBConfig
import navigation.configuration.MainConfig
import navigation.screens.FeatureAScreens
import navigation.screens.FeatureBScreens
import navigation.screens.MainScreens

fun Configuration.toScreen(componentContext: ComponentContext) =
    when (this) {
        MainConfig.Home -> MainScreens.HomeScreen(componentContext)
        MainConfig.ThumbsUp -> MainScreens.ThumbsUpScreen(componentContext)
        FeatureAConfig.HomeA -> FeatureAScreens.HomeAScreen(componentContext)
        FeatureBConfig.HomeB -> FeatureBScreens.HomeBScreen(componentContext)
        FeatureBConfig.EndFeature -> FeatureBScreens.EndScreen(componentContext)
    }
