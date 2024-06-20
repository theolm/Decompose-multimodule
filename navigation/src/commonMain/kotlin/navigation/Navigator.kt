package navigation

import androidx.compose.runtime.compositionLocalOf
import com.arkivanov.decompose.router.stack.StackNavigation
import navigation.configuration.Configuration


val LocalNavigator = compositionLocalOf<Navigator?> { null }

class Navigator(val navigation: StackNavigation<Configuration>) {

}