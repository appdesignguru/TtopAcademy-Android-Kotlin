package com.ttopacademy.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ttopacademy.R
import com.ttopacademy.localdatasources.entities.Video

/** Recycler view's adapter class for showing list of topics. */
class VideoAdapter (private val videos: MutableList<Video>,
                    private val onItemClick: (video: Video) -> Unit) :
    RecyclerView.Adapter<VideoAdapter.ViewHolder>() {

    /** Hold's each item view. */
    class ViewHolder(view: View, private val onItemClick: (video: Video) -> Unit)
        : RecyclerView.ViewHolder(view) {
        private val textView: TextView
        private lateinit var video: Video

        init {
            view.setOnClickListener {
                onItemClick(video)
            }
            textView = itemView.findViewById(R.id.video_list_item_text_view)
        }

        fun bind(video: Video){
            this.video = video
            textView.text = video.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.video_list_item, parent, false)
        return ViewHolder(view, onItemClick)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(videos[position])
    }

    override fun getItemCount(): Int {
        return videos.size
    }
}