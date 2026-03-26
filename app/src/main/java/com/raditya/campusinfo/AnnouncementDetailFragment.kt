package com.raditya.campusinfo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.raditya.campusinfo.databinding.FragmentAnnouncementDetailBinding

class AnnouncementDetailFragment : Fragment() {

    private var _binding: FragmentAnnouncementDetailBinding? = null
    private val binding get() = _binding!!

    // Ambil data argument via Safe Args (Poin 2.3)
    private val args: AnnouncementDetailFragmentArgs by navArgs()

    // Gunakan ViewModel yang sama untuk mencari data
    private val viewModel: HomeViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentAnnouncementDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Ambil ID dari argument
        val announcementId = args.announcementId

        // Cari data yang sesuai di ViewModel
        viewModel.announcements.observe(viewLifecycleOwner) { list ->
            val detail = list.find { it.id == announcementId }

            // Jika ketemu, tampilkan ke UI
            detail?.let {
                binding.tvDetailTitle.text = it.title
                binding.tvDetailDate.text = it.date
                binding.tvDetailCategory.text = it.category
                binding.tvDetailContent.text = it.content
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null // Mencegah memory leak (Poin 2.4)
    }
}