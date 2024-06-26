package com.example.technicaltest.ui.theme

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.technicaltest.data.Launch
import com.example.technicaltest.databinding.ItemLaunchBinding

class LaunchAdapter(private val onClick: (Launch) -> Unit) :
    ListAdapter<Launch, LaunchAdapter.LaunchViewHolder>(LaunchDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LaunchViewHolder {
        val binding = ItemLaunchBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return LaunchViewHolder(binding, onClick)
    }

    override fun onBindViewHolder(holder: LaunchViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class LaunchViewHolder(
        private val binding: ItemLaunchBinding,
        private val onClick: (Launch) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(launch: Launch) {
            binding.launch = launch
            binding.root.setOnClickListener { onClick(launch) }
            binding.executePendingBindings()
        }
    }

    class LaunchDiffCallback : DiffUtil.ItemCallback<Launch>() {
        override fun areItemsTheSame(oldItem: Launch, newItem: Launch): Boolean {
            return oldItem.mission_name == newItem.mission_name
        }

        override fun areContentsTheSame(oldItem: Launch, newItem: Launch): Boolean {
            return oldItem == newItem
        }
    }
}
