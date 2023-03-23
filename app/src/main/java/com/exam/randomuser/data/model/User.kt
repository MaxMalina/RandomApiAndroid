package com.exam.randomuser.data.model

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("name/first") val first: String = "",
    @SerializedName("name/last") val last: String = "",
    @SerializedName("picture/large") val picture: String = "",
)

fun buildUserPreview() = User(
    first = "Name",
    last = "Surname",
    picture = "https://randomuser.me/api/portraits/men/30.jpg",
)