package com.example.technicaltest.data

import com.google.gson.annotations.SerializedName

data class mission(
    @SerializedName("mission_name") val missionName: String,
    @SerializedName("description") val description: String
)