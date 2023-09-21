package com.example.npcamp_fragmentsearch20230918

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.npcamp_fragmentsearch20230918.data.SearchResult
import com.example.npcamp_fragmentsearch20230918.databinding.ItemRecyclerviewBinding

class LikeAdaptor:RecyclerView.Adapter<LikeAdaptor.Holder>() {

    val dataList = ArrayList<SearchResult>()

    inner class Holder(val binding: ItemRecyclerviewBinding): RecyclerView.ViewHolder(binding.root){
        val image = binding.image
        val title = binding.textTitle
        val dateTime = binding.textTime
        val like = binding.like
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LikeAdaptor.Holder {
        val binding = ItemRecyclerviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: LikeAdaptor.Holder, position: Int) {

    }

    override fun getItemCount(): Int {
        return dataList.size
    }


}