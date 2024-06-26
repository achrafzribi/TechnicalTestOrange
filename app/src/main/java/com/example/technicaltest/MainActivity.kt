package com.example.technicaltest

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.technicaltest.databinding.ActivityMainBinding
import com.example.technicaltest.data.Launch
import com.example.technicaltest.ui.theme.LaunchAdapter
import com.example.technicaltest.ui.theme.MainViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val launchAdapter = LaunchAdapter { selectedLaunch ->

        }

        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = launchAdapter
        }

        viewModel.launches.observe(this, Observer<List<Launch>> { launches ->
            launches?.let {
                launchAdapter.submitList(it)
            }
        })


        viewModel.fetchLaunches()
    }
}
