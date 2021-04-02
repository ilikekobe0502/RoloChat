package com.rolochat.homework.model.api

import com.rolochat.homework.model.api.model.response.*
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("users")
    suspend fun getUsers(): Response<Contacts>
}