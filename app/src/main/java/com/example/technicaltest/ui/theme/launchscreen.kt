package com.example.technicaltest.ui.theme


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.technicaltest.ui.theme.MainViewModel

@Composable
fun LaunchesScreen(viewModel: MainViewModel = viewModel()) {
    val launches by viewModel.launches.observeAsState(emptyList())

    Column {
        Text("Launches")
        LazyColumn {
            items(launches) { launch ->
                Text("${launch.missionName} - ${launch.rocket.rocketName}")
            }
        }
    }

    viewModel.fetchLaunches()
}
