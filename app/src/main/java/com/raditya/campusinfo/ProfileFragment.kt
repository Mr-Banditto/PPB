package com.raditya.campusinfo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.raditya.campusinfo.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    // Mengambil Shared ViewModel dari Activity
    private val userViewModel: UserViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Tampilkan NIM statis
        binding.tvProfileNim.text = "NIM: 105223042"

        // Amati nama dari Shared ViewModel (Poin 2.5)
        userViewModel.userName.observe(viewLifecycleOwner) { name ->
            binding.tvProfileName.text = name
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}