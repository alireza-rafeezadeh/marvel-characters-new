package com.disney.hero_datasource.network

import com.disney.hero_datasource.HerosDTO
import com.disney.hero_datasource.toHero
import com.disney.hero_domain.Hero
import io.ktor.client.*
import io.ktor.client.request.*


class HeroServiceImpl(private val httpClient: HttpClient) : HeroService {

    override suspend fun getHeroStats(): List<Hero> {

        return httpClient.get<HerosDTO>(){
            url(EndPoints.CHARACTERS)
        }.data.results.map {
            it.toHero()
        }
    }


}