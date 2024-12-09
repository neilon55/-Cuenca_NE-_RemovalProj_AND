package com.example.eldroidandelphpremoval.model.api

import android.telecom.Call
import androidx.compose.ui.graphics.vector.Path
import retrofit2.Call
import retrofit2.http.*

interface ItemApi {
    @GET("items")
    fun getItems(): Call<List<Item>>

    @POST("items")
    fun createItem(@Body item: Item): Call<Item>

    @PUT("items/{id}")
    fun updateItem(@Path("id") id: Int, @Body item: Item): Call<Item>

    @DELETE("items/{id}")
    fun deleteItem(@Path("id") id: Int): Call<Void>
}


