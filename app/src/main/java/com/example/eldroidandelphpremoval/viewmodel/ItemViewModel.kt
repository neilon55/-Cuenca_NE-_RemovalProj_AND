package com.example.eldroidandelphpremoval.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.eldroidandelphpremoval.model.Item
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ItemViewModel<ItemApi> : ViewModel() {
    private val _items = MutableLiveData<MutableList<Item>>(mutableListOf())
    val items: LiveData<MutableList<Item>> get() = _items

    private val api: ItemApi

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("http://your-laravel-app-url/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        api = retrofit.create(ItemApi::class.java)
    }

    fun fetchItems() {
        // Fetch items from API and update LiveData
    }

    fun addItem(name: String) {
        // Call API to add item
    }

    fun updateItem(id: Int, newName: String) {
        // Call API to update item
    }

    fun deleteItem(id: Int) {
        // Call API to delete item
    }
}