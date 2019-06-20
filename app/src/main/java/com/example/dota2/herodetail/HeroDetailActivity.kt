package com.example.dota2.herodetail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.dota2.R
import com.example.dota2.api.HeroService
import com.example.dota2.model.HeroDetail
import com.example.dota2.util.AndroidLogImpl
import kotlinx.android.synthetic.main.activity_hero_detail.*

class HeroDetailActivity : AppCompatActivity(), HeroDetailContractor.View {
    override fun showError(message: String?) {

    }

    private val presenter: HeroDetailContractor.Presenter = HeroDetailPresenter(
        HeroService.get(),
        AndroidLogImpl()
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hero_detail)
        val heroID = intent.getStringExtra(EXTRA_HERO_ID)


        presenter.atttachView(this)
        presenter.callService(heroID)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detachView()
    }


    override fun showDetail(heroDetail: HeroDetail?) {
        bio.text = heroDetail?.bio
        name.text = heroDetail?.name
        attack.text = heroDetail?.attack

        Glide.with(avatar)
            .load(heroDetail?.portrait?.vert)
            .into(avatar)
    }
    companion object {
        const val EXTRA_HERO_ID = "hero_id"
    }
}

