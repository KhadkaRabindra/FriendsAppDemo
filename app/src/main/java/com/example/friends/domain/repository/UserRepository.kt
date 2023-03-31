package com.example.friends.domain.repository

import com.example.friends.domain.model.User
import com.example.friends.domain.utils.Resource
import kotlinx.coroutines.flow.Flow

interface UserRepository {

    fun getAllUser(count : String): Flow<Resource<ArrayList<User>>>

}