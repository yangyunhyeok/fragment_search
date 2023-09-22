package com.example.npcamp_fragmentsearch20230918

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.npcamp_fragmentsearch20230918.data.SearchResult
import com.example.npcamp_fragmentsearch20230918.databinding.FragmentLikeBinding
import com.example.npcamp_fragmentsearch20230918.databinding.FragmentSearchBinding


class LikeFragment : Fragment() {
    private val binding get() = _binding!!
    private var _binding: FragmentLikeBinding? = null
    private lateinit var mContext:Context
    private lateinit var adapter:LikeAdaptor

    private var likes:List<SearchResult> = listOf()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val mainActivity = activity as MainActivity
        likes = mainActivity.likes

        adapter = LikeAdaptor(mContext).apply {
            dataList = likes.toMutableList() as ArrayList<SearchResult>
        }

        _binding = FragmentLikeBinding.inflate(inflater, container, false).apply {
            likepage.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
            likepage.adapter = adapter
        }

        return binding.root
    }
}