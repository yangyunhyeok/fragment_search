package com.example.npcamp_fragmentsearch20230918

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.npcamp_fragmentsearch20230918.data.SearchResult
import com.example.npcamp_fragmentsearch20230918.databinding.ItemRecyclerviewBinding
import com.google.android.material.transition.Hold

class SearchAdaptor(private val mContext: Context) : RecyclerView.Adapter<SearchAdaptor.Holder>() {

    var dataList = ArrayList<SearchResult>()

    inner class Holder(val binding: ItemRecyclerviewBinding) :
        RecyclerView.ViewHolder(binding.root), View.OnClickListener {
        val image = binding.image
        val title = binding.textTitle
        val dateTime = binding.textTime
        val like = binding.like
        val layout: ConstraintLayout = binding.searchItem

        override fun onClick(v: View?) {
            val position = adapterPosition.takeIf { it != RecyclerView.NO_POSITION } ?: return
            val data = dataList[position]

            data.like = !data.like


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchAdaptor.Holder {
        val binding =
            ItemRecyclerviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: SearchAdaptor.Holder, position: Int) {
        val data = dataList[position]

        Glide.with(mContext) // mContext??
            .load(data.uri) // 불러올 이미지 url
            .into(holder.image) // 이미지를 넣을 뷰

        holder.title.text = data.title
        holder.dateTime.text = data.dateTime
        holder.like.visibility = if (data.like) View.VISIBLE else View.INVISIBLE

    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    fun notifyItemChanged() {

    }

    fun clearItem() {
        dataList.clear()
        notifyItemChanged()
    }


}