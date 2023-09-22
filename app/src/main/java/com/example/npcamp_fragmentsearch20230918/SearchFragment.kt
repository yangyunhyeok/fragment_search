package com.example.npcamp_fragmentsearch20230918

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.core.motion.utils.Utils
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.bumptech.glide.util.Util
import com.example.npcamp_fragmentsearch20230918.data.Documents
import com.example.npcamp_fragmentsearch20230918.data.Image
import com.example.npcamp_fragmentsearch20230918.data.SearchResult
import com.example.npcamp_fragmentsearch20230918.databinding.FragmentSearchBinding
import com.example.npcamp_fragmentsearch20230918.retrofit.NetWorkClient.apiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class SearchFragment : Fragment() {
    private val binding get() = _binding!!
    private var _binding: FragmentSearchBinding? = null
    private lateinit var adaptor: SearchAdaptor
    private lateinit var gridmanager: StaggeredGridLayoutManager
    private lateinit var mContext: Context
    private var Items: ArrayList<SearchResult> = ArrayList()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSearchBinding.inflate(inflater, container, false)

        setupView()
        setupListeners()
        return binding.root
    }

    private fun setupView() {
        gridmanager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        binding.searchRecyclerView.layoutManager = gridmanager
        adaptor = SearchAdaptor(mContext)
        binding.searchRecyclerView.adapter = adaptor
        binding.searchRecyclerView.itemAnimator = null

    }

    private fun setupListeners() {
        binding.btnSearch.setOnClickListener {
            val keyWord = binding.keyword.text.toString()
            Log.d("test", "$keyWord")
            if (keyWord.isNotEmpty()) {
                adaptor.clearItem()
                fetchImageResults(keyWord)
            }
        }
    }

    private fun fetchImageResults(keyWord: String) {
        apiService.requestSearchImage("KakaoAK 3f68eb5f972362fbf9416af7fbea96f5", keyWord, "recency", 1, 80)
            ?.enqueue(object : Callback<Image> {
                @SuppressLint("SuspiciousIndentation")
                override fun onResponse(call: Call<Image>, response: Response<Image>) {
                    response.body()?.meta?.let { meta ->
                        if (meta.total_count > 0) {
                            response.body()!!.documents.forEach { documents ->
                                val title = documents.display_sitename
                                val datetime = documents.datetime
                                val url = documents.thumbnail_url
//                                Log.d("test","$title,$datetime,$url")
                                Items.add(SearchResult(title, datetime, url))
                                Log.d("test","$Items")
                            }
                        }
                    }
                    adaptor.dataList = Items
                    adaptor.notifyDataSetChanged() // 리사이클러뷰 업데이트
                }

                override fun onFailure(call: Call<Image>, t: Throwable) {
                }
            })
    }
}

