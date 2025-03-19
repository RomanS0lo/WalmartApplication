package com.example.walmartapplication.data.repository

import com.example.walmartapplication.data.model.Country

interface CountryRepository {
    suspend fun getCountries(): Result<List<Country>>
}