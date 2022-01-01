package com.disney.hero_datasource.network

object EndPoints {

//    const val BASE_URL = "https://gateway.marvel.com:443/v1/"
//    const val CHARACTERS = "public/characters"

    const val BASE_URL = "https://gateway.marvel.com:443/v1/public"
    const val HERO_STATS = "$BASE_URL/characters"
    const val HERO_SINGLE = "$BASE_URL/characters?apikey=3cf1ea78cb4f10f4b52a3be5f436b46e&hash=389dd7246ac63abbc3d395b352a9e7a8&ts=1"
}