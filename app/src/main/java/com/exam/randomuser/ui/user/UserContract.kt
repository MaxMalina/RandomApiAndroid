package com.exam.randomuser.ui.user

import com.exam.randomuser.data.model.User
import com.exam.randomuser.ui.base.ViewEvent
import com.exam.randomuser.ui.base.ViewSideEffect
import com.exam.randomuser.ui.base.ViewState

class UserContract {

    sealed class Event : ViewEvent {
        object Retry : Event()
        data class UserSelection(val user: User) : Event()
    }

    data class State(
        val users: List<User>,
        val isLoading: Boolean,
        val isError: Boolean,
    ) : ViewState

    sealed class Effect : ViewSideEffect {
        object DataWasLoaded : Effect()

        sealed class Navigation : Effect() {
            data class ToDetails(val link: String): Navigation()
        }
    }

}
