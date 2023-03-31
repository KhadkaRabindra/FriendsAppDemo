package com.example.friends.domain.repository

import com.example.friends.data.remote.ApiService
import com.example.friends.data.remote.UserMapper
import com.example.friends.domain.model.User
import com.example.friends.domain.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepositoryImpl @Inject constructor(
    private var apiService: ApiService,
    private var userMapper: UserMapper
) : UserRepository {
    override fun getAllUser(count : String): Flow<Resource<ArrayList<User>>> {
        return flow {
            emit(Resource.loading())
            emit(Resource.success(data = userMapper.map(apiService.getAllUsers(count))))
        }.catch { e ->
            emit(Resource.error(e))
        }
    }
}