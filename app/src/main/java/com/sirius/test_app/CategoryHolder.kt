package com.sirius.test_app

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sirius.test_app.databinding.TagItemBinding

class CategoryAdapter : RecyclerView.Adapter<CategoryAdapter.CategoryHolder>() {

    private val tagList = ArrayList<String>()

    class CategoryHolder(item: View) : RecyclerView.ViewHolder(item){
        val binding = TagItemBinding.bind(item)

        fun bind(cat: String) = with(binding){
            categoryTag.text = cat
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.tag_item, parent, false)
        return CategoryHolder(view)
    }

    override fun onBindViewHolder(holder: CategoryHolder, position: Int) {
        holder.bind(tagList[position])
    }

    override fun getItemCount(): Int {
        return tagList.size
    }

    fun initializeList(catList: List<String>){
        for (cat in catList){
            tagList.add(cat)
        }
        notifyDataSetChanged()
    }

}