package com.example.dota2

import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainPresenter : MainContractor.Presenter {

    private var view: MainContractor.View? = null

    override fun atttachView(view: MainContractor.View) {
        this.view = view
    }
    override fun detachView(){
        this.view=null
    }

    override fun callService() {
        HeroService.get().getHeroList().enqueue(object : Callback<List<Hero>?> {
            override fun onFailure(call: Call<List<Hero>?>, t: Throwable) {
                Log.e("MainActivity", t.message)
            }

            override fun onResponse(call: Call<List<Hero>?>, response: Response<List<Hero>?>) {
                Log.d("MainActivity", response.body().toString())
                view?.submitList(response.body())
            }
        })
    }

}