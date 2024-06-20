package navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.Children
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.fade
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.stackAnimation
import com.arkivanov.decompose.router.stack.bringToFront
import tabs.HomeScreenContent
import tabs.ThumbsUpContent

@Composable
internal fun RootNavigation(componentContext: ComponentContext) {
    val component = remember { RootComponent(componentContext) }
    val navigator = remember { component.navigation }
    Scaffold(
        bottomBar = {
            BottomNavigation {
                BottomNavigationItem(
                    selected = false,
                    onClick = {
                        navigator.bringToFront(MainConfig.Home)
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
                        navigator.bringToFront(MainConfig.ThumbsUp)
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
    ) {
        Children(
            stack = component.screenStack,
            modifier = Modifier.fillMaxSize(),
            animation = stackAnimation(fade())
        ) {
            when (val child = it.instance) {
                is HomeScreen -> HomeScreenContent(child.componentContext)
                is ThumbsUpScreen -> {
                     ThumbsUpContent(child.componentContext)
                }
            }
        }
    }
}