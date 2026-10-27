
package udg.cuvalles.mynavigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute

@Composable
fun Navigation() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = HomeRoute
    ) {

        composable<HomeRoute> {
            Home(
                onNavigationProfile = { id, name ->
                    navController.navigate(
                        ProfileRoute(
                            userId = id,
                            userName = name
                        )
                    )
                }
            )
        }

        composable<ProfileRoute> { backStackEntry ->

            val profileArgs = backStackEntry.toRoute<ProfileRoute>()

            Profile(
                userId = profileArgs.userId,
                userName = profileArgs.userName,
                onBack = {
                    navController.popBackStack()
                }
            )
        }
    }
}
