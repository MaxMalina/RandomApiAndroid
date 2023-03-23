package com.exam.randomuser.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.exam.randomuser.ui.user.UserContract
import com.exam.randomuser.ui.user.UserViewModel
import com.exam.randomuser.ui.user.composables.UsersScreen
import org.koin.androidx.compose.getViewModel

@Composable
fun UsersScreenDestination(navController: NavController) {
    val viewModel = getViewModel<UserViewModel>()
    UsersScreen(
        state = viewModel.viewState.value,
        effectFlow = viewModel.effect,
        onEventSent = { event ->  viewModel.setEvent(event) },
        onNavigationRequested = { navigationEffect ->
            if (navigationEffect is UserContract.Effect.Navigation.ToDetails) {
                navController.navigateToDetails(navigationEffect.link)
            }
        }
    )
}
