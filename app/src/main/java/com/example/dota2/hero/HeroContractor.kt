package com.example.dota2.hero

import com.example.dota2.model.HeroDetail

interface HeroContractor {
    interface View{
        fun submitList(body: List<HeroDetail>?)
        abstract fun showError(message: String?)
    }
    interface Presenter{
        fun callService()
        fun atttachView(view: View)
        fun detachView()
        abstract fun plus(a: Int, b: Int): Int
    }

}