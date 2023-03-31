package com.example.friends.data.remote

import android.util.Log
import com.example.friends.domain.model.User
import com.example.friends.domain.utils.Mapper
import javax.inject.Inject

class UserMapper @Inject
constructor() :
    Mapper<UserModelDao, ArrayList<User>> {

    override suspend fun map(input: UserModelDao): ArrayList<User> {
        val userList = ArrayList<User>()
        for (i in input.results?.indices!!) {
            val resultItem = input.results[i]
            userList.add(
                User(
                    portrait = resultItem?.picture?.large,
                    fullName = resultItem?.name?.getFullName(),
                    country = resultItem?.location?.country,
                    address = resultItem?.location?.getUserLocation(),
                    city = resultItem?.location?.city,
                    state = resultItem?.location?.state,
                    email = resultItem?.email,
                    phoneNo = resultItem?.phone
                )
            )
        }
        Log.i("+++TAG", userList.size.toString())
        return userList
    }


    private fun Name.getFullName(): String {
        return this.title + " " + (this.first) + " " + (this.last)
    }

    private fun Location.getUserLocation(): String {
        return this.street?.number.toString() + " " + this.street?.name + " " + (this.city) + " " + (this.state) + " " + (this.country)
    }

}