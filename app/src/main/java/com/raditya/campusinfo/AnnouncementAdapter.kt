package com.raditya.campusinfo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.raditya.campusinfo.databinding.ItemAnnouncementBinding

// ListAdapter membantu update list secara otomatis dengan performa tinggi
class AnnouncementAdapter(private val onItemClick: (Announcement) -> Unit) :
    ListAdapter<Announcement, AnnouncementAdapter.AnnouncementViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnnouncementViewHolder {
        val binding = ItemAnnouncementBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AnnouncementViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AnnouncementViewHolder, position: Int) {
        val announcement = getItem(position)
        holder.bind(announcement)
    }

    inner class AnnouncementViewHolder(private val binding: ItemAnnouncementBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(announcement: Announcement) {
            binding.tvTitle.text = announcement.title
            binding.tvDate.text = announcement.date
            binding.tvCategory.text = announcement.category

            // Handle klik item menggunakan lambda (Syarat poin 2.2)
            binding.root.setOnClickListener { onItemClick(announcement) }
        }
    }

    // DiffUtil mengecek data mana yang berubah agar tidak me-refresh seluruh list
    companion object DiffCallback : DiffUtil.ItemCallback<Announcement>() {
        override fun areItemsTheSame(oldItem: Announcement, newItem: Announcement): Boolean {
            return oldItem.id == newItem.id
        }
        override fun areContentsTheSame(oldItem: Announcement, newItem: Announcement): Boolean {
            return oldItem == newItem
        }
    }
}