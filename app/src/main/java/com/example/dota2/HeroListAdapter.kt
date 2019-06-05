package com.example.dota2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_hro.view.*

class HeroListAdapter : ListAdapter<Hero, HeroViewHolder>(object : DiffUtil.ItemCallback<Hero?>() {
    override fun areItemsTheSame(oldItem: Hero, newItem: Hero): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Hero, newItem: Hero): Boolean {
        return oldItem == newItem
    }
}) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_hro, parent, false)
        return HeroViewHolder(view)
    }

    override fun onBindViewHolder(holder: HeroViewHolder, position: Int) {
        holder.bindValue(getItem(position))
    }
}

class HeroViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bindValue(hero: Hero?) {
        itemView.hero_name.text = hero?.name

        Glide.with(itemView.hero_avatar)
            .load(hero?.portrait?.vert)
            .into(itemView.hero_avatar)
    }
}
