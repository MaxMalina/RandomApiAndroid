package com.exam.randomuser.ui.user

import androidx.lifecycle.viewModelScope
import com.exam.randomuser.data.RandomRepository
import com.exam.randomuser.ui.base.BaseViewModel
import kotlinx.coroutines.launch

class UserViewModel(
    private val randomRepository: RandomRepository
) : BaseViewModel<UserContract.Event, UserContract.State, UserContract.Effect>() {

    init { getUsers() }

    override fun setInitialState() = UserContract.State(
        users = emptyList(),
        isLoading = true,
        isError = false,
    )

    override fun handleEvents(event: UserContract.Event) {
        when (event) {
            is UserContract.Event.UserSelection -> setEffect {
                UserContract.Effect.Navigation.ToDetails(event.user.picture)
            }
            is UserContract.Event.Retry -> getUsers()
        }
    }

    fun getUsers() {
        viewModelScope.launch {
            setState { copy(isLoading = true, isError = false) }

            randomRepository.getUsers()
                .onSuccess { users ->
                    setState { copy(users = users, isLoading = false) }
                    setEffect { UserContract.Effect.DataWasLoaded }
                }
                .onFailure {
                    setState { copy(isError = true, isLoading = false) }
                }
        }
    }
}
