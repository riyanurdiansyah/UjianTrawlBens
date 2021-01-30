package com.riyanurdiansyah.trawlbens.codetest2.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.riyanurdiansyah.trawlbens.R
import com.riyanurdiansyah.trawlbens.codetest2.DetailActivity
import com.riyanurdiansyah.trawlbens.codetest2.model.CategoriesObject
import kotlinx.android.synthetic.main.item_categories.view.*

class CategoriesAdapter(private val list: ArrayList<CategoriesObject>): RecyclerView.Adapter<CategoriesAdapter.MyViewHolder>() {

    inner class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(categoriesObject: CategoriesObject) {
            with(itemView){
                tvCategori.text = categoriesObject.strCategory
                Glide.with(context)
                    .load(categoriesObject.strCategoryThumb)
                    .into(ivFoto)

                cvCategori.setOnClickListener {
                    itemView.context.startActivity(Intent(context, DetailActivity::class.java)
                        .putExtra("foto", categoriesObject.strCategoryThumb)
                        .putExtra("kategori", categoriesObject.strCategory)
                        .putExtra("deskripsi", categoriesObject.strCategoryDescription))
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_categories, parent, false)

        return MyViewHolder(view)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(list[position])
    }
}