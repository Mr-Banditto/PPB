package com.raditya.campusinfo

// Data class untuk menampung informasi pengumuman
data class Announcement(
    val id: Int,
    val title: String,
    val date: String,
    val category: String, // Contoh: Akademik, Event, Beasiswa
    val content: String
)