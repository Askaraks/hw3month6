package com.example.hw3month6.ui.playlist

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.homework3.ui.playlist.loadImage
import com.example.hw3month6.data.model.PlayListsModel
import com.example.hw3month6.databinding.ItemPlayListBinding

class PlayListAdapter : RecyclerView.Adapter<PlayListAdapter.AdapterViewHolder>() {
    private var list: ArrayList<PlayListsModel.Item> = arrayListOf()

    @SuppressLint("NotifyDataSetChanged")
    fun setData(Oklist: ArrayList<PlayListsModel.Item> = arrayListOf()){
        list = Oklist
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = AdapterViewHolder (
        ItemPlayListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )


    override fun onBindViewHolder(holder: AdapterViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount() = list.size


    inner class AdapterViewHolder(val binding : ItemPlayListBinding) : ViewHolder(binding.root) {
        fun onBind(playListsModel: PlayListsModel.Item) {
            playListsModel.snippet.thumbnails.default.url.let { binding.playlistImageView.loadImage(it) }
            binding.playlistTitleTextView.text = playListsModel.snippet.localized.title
            binding.playlistDescriptionTextView.text = playListsModel.snippet.localized.description
        }

    }
}