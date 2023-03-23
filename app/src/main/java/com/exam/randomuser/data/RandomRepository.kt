package com.exam.randomuser.data

import com.exam.randomuser.data.model.User

interface RandomRepository {
    suspend fun getUsers(): Result<List<User>>
}