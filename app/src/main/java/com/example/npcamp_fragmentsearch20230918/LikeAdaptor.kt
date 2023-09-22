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

class LikeAdaptor(var mContext: Context) : RecyclerView.Adapter<LikeAdaptor.Holder>() {

    var dataList = mutableListOf<SearchResult>()

    inner class Holder(val binding: ItemRecyclerviewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val image = binding.image
        val title = binding.textTitle
        val dateTime = binding.textTime
        val like = binding.like
        val layout: ConstraintLayout = binding.searchItem

        init {
            like.visibility = View.GONE

            layout.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    dataList.removeAt(position)
                    notifyItemRemoved(position)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LikeAdaptor.Holder {
        val binding =
            ItemRecyclerviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: LikeAdaptor.Holder, position: Int) {
        Glide.with(mContext) // mContext??
            .load(dataList[position].uri) // 불러올 이미지 url
            .into(holder.image) // 이미지를 넣을 뷰

        holder.title.text = dataList[position].title
        holder.dateTime.text = dataList[position].dateTime
        holder.like.visibility = if (dataList[position].like) View.VISIBLE else View.INVISIBLE

    }

    override fun getItemCount(): Int {
        return dataList.size
    }


}