package com.exam.randomuser.data

import com.exam.randomuser.data.model.User
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.confirmVerified
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Test

class RandomRepositoryTest {

    private val defaultSize = "10"
    private val randomApi = mockk<RandomApi>()
    private val randomRepository: RandomRepository = RandomRepositoryImpl(randomApi)

    @Test
    fun `when getUsers called then call getUsers from API`() = runTest {
        val users = listOf(User())
        coEvery { randomApi.getUsers(defaultSize) } returns users

        val result = randomRepository.getUsers()

        assert(result.isSuccess)
        coVerify(exactly = 1) { randomApi.getUsers(defaultSize) }
        confirmVerified(randomApi)
    }

    @Test
    fun `when getUsers called then returns failure`() = runTest {
        coEvery { randomApi.getUsers(defaultSize) } throws Exception("")

        val result = randomRepository.getUsers()

        assert(result.isFailure)
    }
}