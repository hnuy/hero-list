package com.example.dota2.herodetail

import com.example.dota2.model.HeroDetail

interface HeroDetailContractor {
    interface View{
        fun showDetail(heroDetail: HeroDetail?)
        abstract fun showError(message: String?)
    }
    interface Presenter{
        fun callService(heroId: String)
        fun atttachView(view: View)
        fun detachView()

    }

}