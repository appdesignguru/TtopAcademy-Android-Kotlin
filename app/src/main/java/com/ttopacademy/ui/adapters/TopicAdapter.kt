package com.ttopacademy.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ttopacademy.R
import com.ttopacademy.localdatasources.entities.Topic

/** Recycler view's adapter class for showing list of subjects. */
class TopicAdapter (private val topics: MutableList<Topic>,
                    private val onItemClick: (topic: Topic) -> Unit) :
    RecyclerView.Adapter<TopicAdapter.ViewHolder>() {

    /** Hold's each item view. */
    class ViewHolder(view: View, private val onItemClick: (topic: Topic) -> Unit)
        : RecyclerView.ViewHolder(view) {
        private val textView: TextView
        private lateinit var topic: Topic

        init {
            view.setOnClickListener {
                onItemClick(topic)
            }
            textView = itemView.findViewById(R.id.topic_list_item_text_view)
        }

        fun bind(topic: Topic){
            this.topic = topic
            textView.text = topic.name
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.topic_list_item, parent, false)
        return ViewHolder(view, onItemClick)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(topics[position])
    }

    override fun getItemCount(): Int {
        return topics.size
    }
}