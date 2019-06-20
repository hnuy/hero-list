package com.example.dota2.hero

import com.example.dota2.util.AndroidLog
import com.example.dota2.model.HeroDetail
import com.example.dota2.api.HeroService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HeroPresenter(
    private val service: HeroService,
    private val log: AndroidLog
) : HeroContractor.Presenter {

    private var view: HeroContractor.View? = null

    override fun atttachView(view: HeroContractor.View) {
        this.view = view
    }

    override fun detachView() {
        this.view = null
    }

    override fun callService() {
        service.getHeroList().enqueue(object : Callback<List<HeroDetail>?> {
            override fun onFailure(call: Call<List<HeroDetail>?>, t: Throwable) {
                log.e("HeroActivity", t.message)
            view?.showError(t.message)
            }

            override fun onResponse(call: Call<List<HeroDetail>?>, response: Response<List<HeroDetail>?>) {
                log.d("HeroActivity", response.body().toString())
                view?.submitList(response.body())
            }
        })
    }

    override fun plus(a: Int, b: Int): Int {
        return a + b
    }
}