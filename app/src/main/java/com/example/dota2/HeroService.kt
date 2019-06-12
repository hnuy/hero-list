package com.example.dota2

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface HeroService {
    @GET("english/heroes.json")
    fun getHeroList():Call<List<Hero>>

    companion object {
        private var service: HeroService? = null
        fun get(): HeroService {
            if (service == null){
                val retrofit = Retrofit.Builder()
                    .baseUrl("https://peerapongsam.github.io/heropedia/json/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                 service = retrofit.create(HeroService::class.java)
        }
        return service!!
         }
    }
}