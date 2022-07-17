package com.ttopacademy.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ttopacademy.R
import com.ttopacademy.localdatasources.entities.Category

/** Recycler view's adapter class for showing list of categories. */
class CategoryAdapter(private val categories: MutableList<Category>,
                            private val onItemClick: (category: Category) -> Unit) :
    RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {

    /** Hold's each item view. */
    class ViewHolder(view: View, private val onItemClick: (category: Category) -> Unit)
        : RecyclerView.ViewHolder(view) {
        private val textView: TextView
        private lateinit var category: Category

        init {
            view.setOnClickListener {
                onItemClick(category)
            }
            textView = itemView.findViewById(R.id.category_list_item_text_view)
        }

        fun bind(category: Category){
            this.category = category
            textView.text = category.name
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int
    ): ViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.category_list_item, parent, false)
        return ViewHolder(view, onItemClick)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(categories[position])
    }

    override fun getItemCount(): Int {
        return categories.size
    }
}