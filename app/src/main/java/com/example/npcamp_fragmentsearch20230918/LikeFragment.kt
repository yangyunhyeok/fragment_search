package com.example.npcamp_fragmentsearch20230918

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.npcamp_fragmentsearch20230918.databinding.FragmentLikeBinding
import com.example.npcamp_fragmentsearch20230918.databinding.FragmentSearchBinding


class LikeFragment : Fragment() {
    private val binding get() = _binding!!
    private var _binding: FragmentLikeBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLikeBinding.inflate(inflater, container, false)
        return binding.root
    }
}