package com.exam.randomuser.ui

import com.exam.randomuser.data.RandomRepository
import com.exam.randomuser.data.model.User
import com.exam.randomuser.ui.user.UserContract
import com.exam.randomuser.ui.user.UserViewModel
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.junit.Test
import kotlin.test.assertEquals

@DelicateCoroutinesApi
class UsersViewModelTest {

    @get:Rule
    val mainCoroutineRule = MainCoroutineRule()

    private val randomRepository = mockk<RandomRepository>()

    @Test
    fun `when view model initialized then emit initial view state`() = runTest {
        val expectedInitialViewState = UserContract.State(
            users = emptyList(),
            isLoading = true,
            isError = false
        )

        val viewModel = UserViewModel(randomRepository)

        assertEquals(expectedInitialViewState, viewModel.viewState.value)
    }

    @Test
    fun `when getUsers called then emit a view state`() = runTest {
        val users = listOf(User(last = "Gromov"))
        val expectedViewState = UserContract.State(
            users = users,
            isLoading = false,
            isError = false
        )
        coEvery { randomRepository.getUsers() } returns Result.success(users)

        val viewModel = UserViewModel(randomRepository)

        assertEquals(expectedViewState, viewModel.viewState.value)
    }
}