package com.example.dota2

import retrofit2.Call
import retrofit2.http.GET

interface HeroService {
    @GET("english/heroes.json")
    fun getHeroList():Call<List<Hero>>
}