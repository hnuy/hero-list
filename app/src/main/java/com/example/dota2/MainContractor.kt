package com.example.dota2

interface MainContractor {
    interface View{
        fun submitList(body: List<Hero>?)
    }
    interface Presenter{
        fun callService()
        fun atttachView(view: View)
        fun detachView()
    }
}