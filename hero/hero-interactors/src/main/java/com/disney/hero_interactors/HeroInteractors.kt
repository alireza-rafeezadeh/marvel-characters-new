package com.disney.hero_interactors

import com.disney.hero_datasource.network.HeroService


data class HeroInteractors(
    val getHeros: GetHeros,
    // TODO(Add other hero interactors)
) {
    companion object Factory {
        fun build(): HeroInteractors{
            val service = HeroService.build()
            return HeroInteractors(
                getHeros = GetHeros(
                    service = service,
                ),
            )
        }
    }
}