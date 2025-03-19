package com.example.walmartapplication.ui.country_list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.walmartapplication.data.model.Country
import com.example.walmartapplication.data.repository.CountryRepository
import com.example.walmartapplication.ui.state.UiState
import kotlinx.coroutines.launch

class CountryViewModel(private val repository: CountryRepository) : ViewModel() {
    private val _countries = MutableLiveData<UiState<List<Country>>>()
    val countries: LiveData<UiState<List<Country>>> = _countries

    init {
        fetchCountries()
    }

    fun fetchCountries() {
        viewModelScope.launch {
            _countries.value = UiState.Loading
            repository.getCountries().onSuccess { countries ->
                _countries.postValue(UiState.Success(countries))
            }.onFailure { error ->
                _countries.postValue(UiState.Error(error.message ?: "Unknown error occurred"))
            }
        }
    }
}
