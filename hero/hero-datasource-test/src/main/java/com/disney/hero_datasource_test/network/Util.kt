package com.disney.hero_datasource_test.network

import com.disney.hero_datasource.HerosDTO
import com.disney.hero_datasource.toHero
import com.disney.hero_domain.Hero
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

private val json = Json {
    ignoreUnknownKeys = true
}

@ExperimentalSerializationApi
fun serializeHeroData(jsonData: String): List<Hero>{
    val heros: List<Hero> = json.decodeFromString<HerosDTO>(jsonData).data.results.map {
        it.toHero()
    }
//    map { it.toHero() }
    return heros
}