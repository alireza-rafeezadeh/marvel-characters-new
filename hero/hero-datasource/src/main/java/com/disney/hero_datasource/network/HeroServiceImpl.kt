package com.disney.hero_datasource.network

import com.disney.hero_datasource.HerosDTO
import com.disney.hero_datasource.toHero
import com.disney.hero_domain.Hero
import io.ktor.client.*
import io.ktor.client.request.*


class HeroServiceImpl(private val httpClient: HttpClient) : HeroService {

    override suspend fun getHeroStats(): List<Hero> {

        return httpClient.get<HerosDTO>(){
            url(EndPoints.HERO_STATS)
            addQueryParams()
        }.data.results.map {
            it.toHero()
        }
    }



    override suspend fun getSingleHeroById(): Hero {

        return httpClient.get<HerosDTO>(){
            url(EndPoints.HERO_SINGLE, path = "fghg")
        }.data.results.map {
            it.toHero()
        }[0]
    }


}



private fun HttpRequestBuilder.addQueryParams() {
    parameter("apikey", ApiParameters.API_KEY)
    parameter("hash", ApiParameters.HASH)
    parameter("ts", ApiParameters.TS)
}