package com.example.klikkinpruebatecnica.presentation.home.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.klikkinpruebatecnica.R
import com.example.klikkinpruebatecnica.models.CategoryItem

class CategoryAdapter(val onClickAction: (() -> Unit)):
    RecyclerView.Adapter<CategoryAdapter.ViewHolder>()  {

    private var dataSet: List<CategoryItem> = mutableListOf<CategoryItem>()

    fun setDatabase(db: List<CategoryItem>){
        dataSet = db
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView = view.findViewById(R.id.tx_header)
        val image: ImageView = view.findViewById(R.id.img_header)
        val container: CardView = view.findViewById(R.id.cv_category_item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.cv_category_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = dataSet.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int){
        with(holder){
            title.text = holder.itemView.getContext().getString(dataSet[position].category)
            image.setImageResource(dataSet[position].image)
            container.setOnClickListener {
                onClickAction.invoke()
            }
        }
    }
}