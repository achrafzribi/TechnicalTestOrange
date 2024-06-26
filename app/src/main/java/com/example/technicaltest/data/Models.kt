package com.example.technicaltest.data



data class Launch(
    val mission_name: String,
    val launch_date_utc: String,
    val details: String?,

)

data class Mission(
    val mission_name: String,
    val description: String,

)
