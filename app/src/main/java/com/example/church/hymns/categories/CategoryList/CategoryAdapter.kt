package com.example.church.hymns.categories.CategoryList

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.church.R
import com.example.church.hymns.categories.HymnCategory

class CategoryAdapter(private val onClick: (HymnCategory) -> Unit) :
    ListAdapter<HymnCategory, CategoryAdapter.CategoryViewHolder>(CategoryDiffCallback) {

    /* ViewHolder for Flower, takes in the inflated view and the onClick behavior. */
    class CategoryViewHolder(itemView: View, val onClick: (HymnCategory) -> Unit) :
        RecyclerView.ViewHolder(itemView) {
        private val categoryTextView: TextView = itemView.findViewById(R.id.categoryListText)
        private var currentCategory: HymnCategory? = null

        init {
            itemView.setOnClickListener {
                currentCategory?.let {
                    onClick(it)
                }
            }
        }

        /* Bind flower name and image. */
        fun bind(category: HymnCategory) {
            currentCategory = category

            categoryTextView.text = category.name

        }
    }

    /* Creates and inflates view and return FlowerViewHolder. */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.hymn_category_recycler, parent, false)
        return CategoryViewHolder(view, onClick)
    }

    /* Gets current flower and uses it to bind view. */
    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val category = getItem(position)
        holder.bind(category)

    }
}

object CategoryDiffCallback : DiffUtil.ItemCallback<HymnCategory>() {
    override fun areItemsTheSame(oldItem: HymnCategory, newItem: HymnCategory): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: HymnCategory, newItem: HymnCategory): Boolean {
        return oldItem.id == newItem.id
    }
}