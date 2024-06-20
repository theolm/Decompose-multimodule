package navigation

import RegisterFeatureAGraphProvider
import RegisterFeatureBGraphProvider
import RegisterMainGraphProvider
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.Children
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.fade
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.stackAnimation
import com.arkivanov.decompose.extensions.compose.jetbrains.subscribeAsState
import com.arkivanov.decompose.router.stack.bringToFront
import navigation.configuration.MainConfig
import navigation.screens.MainScreens
import tabs.HomeScreenContent
import tabs.ThumbsUpContent

@Composable
internal fun RootNavigation(componentContext: ComponentContext) {
    val component = remember { RootComponent(componentContext) }
    val stack by component.screenStack.subscribeAsState()

    CompositionLocalProvider(LocalNavigator provides component.navigator) {
        val navigator = LocalNavigator.current
        Scaffold(
            bottomBar = {
                if (stack.isTab()) {
                    BottomNavigation {
                        BottomNavigationItem(
                            selected = false,
                            onClick = {
                                navigator?.apply {
                                    navigation.bringToFront(MainConfig.Home)
                                }
                            },
                            icon = {
                                Icon(
                                    imageVector = Icons.Filled.Home,
                                    contentDescription = "Home"
                                )
                            },
                        )

                        BottomNavigationItem(
                            selected = false,
                            onClick = {
                                navigator?.apply {
                                    navigation.bringToFront(MainConfig.ThumbsUp)
                                }
                            },
                            icon = {
                                Icon(
                                    imageVector = Icons.Filled.ThumbUp,
                                    contentDescription = "ThumbUp"
                                )
                            },
                        )
                    }
                }
            }
        ) {
            Children(
                stack = component.screenStack,
                modifier = Modifier.fillMaxSize(),
                animation = stack.getAnimation()
            ) {
                it.instance.apply {
                    RegisterMainGraphProvider()
                    RegisterFeatureAGraphProvider()
                    RegisterFeatureBGraphProvider()
                }
            }
        }
    }
}