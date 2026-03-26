package com.raditya.campusinfo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    private val _announcements = MutableLiveData<List<Announcement>>()
    val announcements: LiveData<List<Announcement>> = _announcements

    init {
        loadDummyData()
    }

    private fun loadDummyData() {
        val list = listOf(
            Announcement(1, "Libur Idul Fitri 1446 H", "25 Maret 2026", "Akademik", "Sesuai kalender akademik, perkuliahan diliburkan mulai tanggal..."),
            Announcement(2, "Pendaftaran Beasiswa Unggulan", "28 Maret 2026", "Beasiswa", "Dibuka pendaftaran beasiswa bagi mahasiswa semester 2 dan 4..."),
            Announcement(3, "Workshop Android Development", "1 April 2026", "Event", "Ikuti workshop gratis membangun aplikasi Android dengan Kotlin..."),
            Announcement(4, "Ujian Tengah Semester Ganjil", "10 April 2026", "Akademik", "Jadwal UTS dapat dilihat melalui portal mahasiswa masing-masing..."),
            Announcement(5, "Lomba Inovasi Teknologi 2026", "15 April 2026", "Event", "Tunjukkan ide kreatifmu dalam ajang tahunan inovasi teknologi...")
        )
        _announcements.value = list
    }
}