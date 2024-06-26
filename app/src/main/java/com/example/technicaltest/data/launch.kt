package com.example.technicaltest.data

import com.google.gson.annotations.SerializedName

data class launch(
    @SerializedName("mission_name") val missionName: String,
    @SerializedName("launch_date_utc") val launchDateUtc: String,
    @SerializedName("rocket") val rocket: Rocket
)

data class Rocket(
    @SerializedName("rocket_name") val rocketName: String
)
