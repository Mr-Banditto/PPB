package com.raditya.campusinfo
import androidx.fragment.app.activityViewModels
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.raditya.campusinfo.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    // Inisialisasi Shared ViewModel (Poin 2.5)
    private val userViewModel: UserViewModel by activityViewModels()

    // Inisialisasi ViewModel (Poin 2.4)
    private val viewModel: HomeViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        userViewModel.setUserName("Raditya")
        // Setup Adapter dengan Klik Listener
        val adapter = AnnouncementAdapter { announcement ->
            // Saat diklik, pindah ke DetailFragment menggunakan Safe Args (Poin 2.3)
            val action = HomeFragmentDirections.actionHomeFragmentToAnnouncementDetailFragment(announcement.id)
            findNavController().navigate(action)
        }

        binding.rvAnnouncements.adapter = adapter

        // Amati (Observe) data dari ViewModel
        viewModel.announcements.observe(viewLifecycleOwner) { list ->
            adapter.submitList(list)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null // Mencegah memory leak (Poin 2.4)
    }
}