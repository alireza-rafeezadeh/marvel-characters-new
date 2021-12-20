package com.disney.hero_datasource

import com.disney.hero_domain.*
import kotlinx.serialization.Serializable

@Serializable
data class HerosDTO(
    val attributionHTML: String,
    val attributionText: String,
    val code: Int,
    val copyright: String,
    val `data`: Data,
    val etag: String,
    val status: String
)

@Serializable
data class Data(
    val count: Int,
    val limit: Int,
    val offset: Int,
    val results: List<Result>,
    val total: Int
)

@Serializable
data class Result(
    val comics: Comics,
    val description: String,
    val events: Events,
    val id: Int,
    val modified: String,
    val name: String,
    val resourceURI: String,
    val series: Series,
    val stories: Stories,
    val thumbnail: Thumbnail,
    val urls: List<Url>
)


fun Result.toHero() =
    Hero(
        name = name,
        comics = comics,
        description = description,
        events = events,
        id = id,
        series = series,
        thumbnail = thumbnail,
        urls = urls
    )