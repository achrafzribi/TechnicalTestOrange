package com.example.technicaltest.ui.theme

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.technicaltest.ui.theme.MainViewModel

@Composable
fun MissionsScreen(viewModel: MainViewModel = viewModel()) {
    val missions by viewModel.missions.observeAsState(emptyList())

    Column {
        Text("Missions")
        LazyColumn {
            items(missions) { mission ->
                Text("${mission.missionName} - ${mission.description}")
            }
        }
    }

    viewModel.fetchMissions()
}