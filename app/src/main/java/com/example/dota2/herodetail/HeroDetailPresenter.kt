package com.example.dota2.herodetail

import com.bumptech.glide.Glide
import com.example.dota2.api.HeroService
import com.example.dota2.model.HeroDetail
import com.example.dota2.util.AndroidLog
import kotlinx.android.synthetic.main.activity_hero_detail.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HeroDetailPresenter(
    private val service: HeroService,
    private val log: AndroidLog
) : HeroDetailContractor.Presenter {

    override fun atttachView(view: HeroDetailContractor.View) {
        this.view = view
    }

    override fun detachView() {
        this.view = null
    }

    private var view: HeroDetailContractor.View? = null


    override fun callService(heroId: String) {
        service.getHeroDetail(heroId).enqueue(object : Callback<HeroDetail?> {
            override fun onFailure(call: Call<HeroDetail?>, t: Throwable) {
            }

            override fun onResponse(call: Call<HeroDetail?>, response: Response<HeroDetail?>) {
                val heroDetail = response.body()

                view?.showDetail(heroDetail)
            }
        })
    }
}
