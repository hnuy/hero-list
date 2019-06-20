package com.example.dota2.hero

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.dota2.model.HeroDetail
import com.example.dota2.R
import kotlinx.android.synthetic.main.item_hro.view.*

class HeroListAdapter : ListAdapter<HeroDetail, HeroViewHolder>(object : DiffUtil.ItemCallback<HeroDetail?>() {
    override fun areItemsTheSame(oldItem: HeroDetail, newItem: HeroDetail): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: HeroDetail, newItem: HeroDetail): Boolean {
        return oldItem == newItem
    }
}) {

    var listener: OnHeroClickListener?=null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_hro, parent, false)
        return HeroViewHolder(view)
    }

    override fun onBindViewHolder(holder: HeroViewHolder, position: Int) {
        holder.bindValue(getItem(position))
        holder.itemView.setOnClickListener{
            listener?.onClick(getItem(position))
        }
    }
}

class HeroViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bindValue(hero: HeroDetail?) {
        itemView.hero_name.text = hero?.name

        Glide.with(itemView.hero_avatar)
            .load(hero?.portrait?.vert)
            .into(itemView.hero_avatar)
    }
}
interface OnHeroClickListener{
    fun onClick(hero: HeroDetail?)
}