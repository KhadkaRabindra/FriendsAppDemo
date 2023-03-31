package com.example.friends.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.friends.domain.model.User
import com.example.friends.domain.repository.UserRepository
import com.example.friends.domain.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(private val repository: UserRepository) : ViewModel() {

    val userListDetailState: MutableStateFlow<Resource<ArrayList<User>>> =
        MutableStateFlow(Resource.loading())

    var selectedUser: User? = null

    fun getAllUsers(count: String) {
        repository.getAllUser(count).map {
            userListDetailState.value = it
        }.launchIn(viewModelScope)
    }
}