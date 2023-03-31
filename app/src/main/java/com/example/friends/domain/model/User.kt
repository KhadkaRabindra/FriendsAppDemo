package com.example.friends.domain.model

data class User(
    var portrait: String? = null,
    var fullName: String? = null,
    var country: String? = null,
    var address: String? = null,
    var city: String? = null,
    var state: String? = null,
    var email: String? = null,
    var phoneNo: String? = null
)