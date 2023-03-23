package com.exam.randomuser.data

import com.exam.randomuser.data.Urls.DEFAULT_SIZE
import com.exam.randomuser.data.model.User
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RandomRepositoryImpl(
    private val randomApi: RandomApi,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO,
) : RandomRepository {

    override suspend fun getUsers(): Result<List<User>> = makeApiCall(dispatcher) {
        randomApi.getUsers(DEFAULT_SIZE)
    }
}

suspend fun <T> makeApiCall(
    dispatcher: CoroutineDispatcher,
    call: suspend () -> T
): Result<T> = runCatching {
    withContext(dispatcher) {
        call.invoke()
    }
}