package com.example.walmartapplication.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.walmartapplication.data.network.RetrofitClient
import com.example.walmartapplication.data.repository.CountryRepositoryImpl
import com.example.walmartapplication.ui.country_list.CountryViewModel

class CountryViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CountryViewModel::class.java)) {
            val repository = CountryRepositoryImpl(RetrofitClient.apiService)
            @Suppress("UNCHECKED_CAST") return CountryViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}