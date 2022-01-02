package com.disney.hero_domain

import kotlinx.serialization.Serializable

data class Hero(
    val comics: Comics,
    val description: String,
    val events: Events,
    val id: Int,
//    val modified: String,
    val name: String,
//    val resourceURI: String,
    val series: Series,
//    val stories: Stories,
    val thumbnail: Thumbnail,
    val urls: List<Url>
)

@Serializable
data class Comics(
    val available: Int,
    val collectionURI: String,
    val items: List<Item>,
    val returned: Int
)

@Serializable
data class Events(
    val available: Int,
    val collectionURI: String,
    val items: List<Item>,
    val returned: Int
)

@Serializable
data class Series(
    val available: Int,
    val collectionURI: String,
    val items: List<Item>,
    val returned: Int
)

@Serializable
data class Stories(
    val available: Int,
    val collectionURI: String,
    val items: List<Item>,
    val returned: Int
)

@Serializable
data class Thumbnail(
    val extension: String,
    val path: String
)

fun Thumbnail.getImageFullPath() = "${path}/portrait_incredible.${extension}"
fun Thumbnail.getLandscapeImageFullPath() = "${path}/landscape_incredible.${extension}"


@Serializable
data class Url(
    val type: String,
    val url: String
)

@Serializable
data class Item(
    val name: String,
    val resourceURI: String
)

