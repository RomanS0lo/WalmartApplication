package com.example.walmartapplication.data.repository

import com.example.walmartapplication.data.model.Country
import com.example.walmartapplication.data.network.ApiService

class CountryRepositoryImpl(private val apiService: ApiService) : CountryRepository {
    override suspend fun getCountries(): Result<List<Country>> {
        return try {
            val response = apiService.getCountries()
            Result.success(response)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
