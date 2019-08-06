package com.implizstudio.android.app.wk.data.model

import com.google.gson.annotations.SerializedName

data class UserResponse( @SerializedName("user") val user: User ) {

    data class User(
        @SerializedName("id") val id: String?,
        @SerializedName("photo") val photo: String?,
        @SerializedName("firstName") val firstName: String?,
        @SerializedName("lastName") val lastName: String?,
        @SerializedName("email") val email: String?,
        @SerializedName("status") val status: String?,
        @SerializedName("exp") val exp: String?
    )

}