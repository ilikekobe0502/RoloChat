package com.rolochat.homework.model.api.model.response

import com.google.gson.annotations.SerializedName

data class ApiBaseItem<T>(
    @SerializedName("result")
    val result: T?
)