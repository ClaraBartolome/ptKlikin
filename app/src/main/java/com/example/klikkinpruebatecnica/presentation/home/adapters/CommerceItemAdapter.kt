package com.example.klikkinpruebatecnica.presentation.home.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.klikkinpruebatecnica.R
import com.example.klikkinpruebatecnica.core.data.models.CommerceBasic
import com.example.klikkinpruebatecnica.models.CategoryItem

class CommerceItemAdapter(val onClickAction: (() -> Unit)):
    RecyclerView.Adapter<CommerceItemAdapter.ViewHolder>()  {

    private var dataSet: MutableList<CommerceBasic> = mutableListOf<CommerceBasic>()

    fun setDatabase(db: List<CommerceBasic>){
        dataSet.clear()
        dataSet = db.toMutableList()
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val txDistance: TextView = view.findViewById(R.id.tx_distance)
        val imageHeader: ImageView = view.findViewById(R.id.img_header)
        val container: CardView = view.findViewById(R.id.cv_commerce_item_container)
        val imgBody: ImageView = view.findViewById(R.id.img_body)
        val txBodyTitle: TextView = view.findViewById(R.id.tx_title_body)
        val txBodySubtitle: TextView = view.findViewById(R.id.tx_body_message)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.cv_commerce_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = dataSet.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int){
        with(holder){

            container.setOnClickListener {
                onClickAction.invoke()
            }
        }
    }
}