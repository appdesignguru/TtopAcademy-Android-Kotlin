package com.ttopacademy.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ttopacademy.R
import com.ttopacademy.localdatasources.entities.Subject

/** Recycler view's adapter class for showing list of subjects. */
class SubjectAdapter(private val subjects: MutableList<Subject>,
                      private val onItemClick: (subject: Subject) -> Unit) :
    RecyclerView.Adapter<SubjectAdapter.ViewHolder>() {

    /** Hold's each item view. */
    class ViewHolder(view: View, private val onItemClick: (subject: Subject) -> Unit)
        : RecyclerView.ViewHolder(view) {
        private val textView: TextView
        private lateinit var subject: Subject

        init {
            view.setOnClickListener {
                onItemClick(subject)
            }
            textView = itemView.findViewById(R.id.subject_list_item_text_view)
        }

        fun bind(subject: Subject){
            this.subject = subject
            textView.text = subject.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.subject_list_item, parent, false)
        return ViewHolder(view, onItemClick)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(subjects[position])
    }

    override fun getItemCount(): Int {
        return subjects.size
    }
}