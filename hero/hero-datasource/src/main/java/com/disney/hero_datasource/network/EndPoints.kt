package com.disney.hero_datasource.network

object EndPoints {

//    const val BASE_URL = "https://gateway.marvel.com:443/v1/"
//    const val CHARACTERS = "public/characters"

    const val BASE_URL = "https://gateway.marvel.com:443/v1/public"
    const val HERO_STATS = "$BASE_URL/characters"
    const val HERO_SINGLE = "$BASE_URL/characters"
}