package com.example.dota2.hero

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import com.example.dota2.*
import com.example.dota2.api.HeroService
import com.example.dota2.herodetail.HeroDetailActivity
import com.example.dota2.model.HeroDetail
import com.example.dota2.util.AndroidLogImpl


class HeroActivity : AppCompatActivity(), HeroContractor.View {

    override fun showError(message: String?) {

    }

    override fun submitList(body: List<HeroDetail>?) {
        heroListAdapter.submitList(body)

    }

    private val presenter: HeroContractor.Presenter = HeroPresenter(
        HeroService.get(),
        AndroidLogImpl()
    )

    private val heroListAdapter = HeroListAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        hero_list.adapter = heroListAdapter

        heroListAdapter.listener = object: OnHeroClickListener {
            override fun onClick(hero: HeroDetail?) {
                val intent = Intent(this@HeroActivity, HeroDetailActivity::class.java)
                intent.putExtra(HeroDetailActivity.EXTRA_HERO_ID,hero?.id)
                startActivity(intent)

            }
        }

        presenter.callService()
        presenter.atttachView(this)

    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detachView()
    }
}
