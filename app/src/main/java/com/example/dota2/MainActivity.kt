package com.example.dota2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit



class MainActivity : AppCompatActivity() {

  private  val heroListAdapter = HeroListAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        hero_list.adapter = heroListAdapter


        callService()
    }

    private fun callService() {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://peerapongsam.github.io/heropedia/json/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val service = retrofit.create(HeroService::class.java)
        service.getHeroList().enqueue(object: Callback<List<Hero>?> {
            override fun onFailure(call: Call<List<Hero>?>, t: Throwable) {
                Log.e("MainActivity",t.message)
            }

            override fun onResponse(call: Call<List<Hero>?>, response: Response<List<Hero>?>) {
                Log.d("MainActivity",response.body().toString())
                heroListAdapter.submitList(response.body())
            }
        })
    }
}
