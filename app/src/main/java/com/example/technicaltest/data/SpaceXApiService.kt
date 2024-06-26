package com.example.technicaltest.data



import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface SpaceXApiService {
    @GET("launches")
    suspend fun getLaunches(): List<Launch>

    @GET("missions")
    suspend fun getMissions(): List<Mission>

    companion object {
        private const val BASE_URL = "https://api.spacexdata.com/v3/"

        fun create(): SpaceXApiService {
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(SpaceXApiService::class.java)
        }
    }
}

