package com.exam.randomuser.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.exam.randomuser.ui.navigation.Navigation.Args.USER_DETAILS

@Composable
fun AppNavigation() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Navigation.Routes.USERS
    ) {
        composable(
            route = Navigation.Routes.USERS
        ) {
            UsersScreenDestination(navController)
        }

        composable(
            route = Navigation.Routes.REPOS,
            arguments = listOf(navArgument(name = USER_DETAILS) {
                type = NavType.StringType
            })
        ) { backStackEntry ->
            val userId = requireNotNull(backStackEntry.arguments?.getString(USER_DETAILS)) { "User link is required as an argument" }
        }
    }
}

object Navigation {
    object Args {
        const val USER_DETAILS = "user_details"
    }

    object Routes {
        const val USERS = "users"
        const val REPOS = "$USERS/{$USER_DETAILS}"
    }

}

fun NavController.navigateToDetails(link: String) {
    navigate(route = "${Navigation.Routes.USERS}/$link")
}