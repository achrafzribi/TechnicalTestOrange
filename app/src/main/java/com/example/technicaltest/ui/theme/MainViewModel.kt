// MainViewModel.kt
package com.example.technicaltest.ui.theme

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.technicaltest.data.Launch
import com.example.technicaltest.data.Mission
import com.example.technicaltest.data.SpaceXApiService
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    private val spaceXApiService = SpaceXApiService.create()

    private val _launches = MutableLiveData<List<Launch>>()
    val launches: LiveData<List<Launch>> get() = _launches

    private val _missions = MutableLiveData<List<Mission>>()
    val missions: LiveData<List<Mission>> get() = _missions

    fun fetchLaunches() {
        viewModelScope.launch {
            try {
                _launches.value = spaceXApiService.getLaunches()
            } catch (e: Exception) {
                // Handle the error
            }
        }
    }

    fun fetchMissions() {
        viewModelScope.launch {
            try {
                _missions.value = spaceXApiService.getMissions()
            } catch (e: Exception) {
                // Handle the error
            }
        }
    }
}
