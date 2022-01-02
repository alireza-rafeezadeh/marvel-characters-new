package com.disney.marvelcharacters.di.heroDetail

import com.disney.hero_interactors.GetHeros
import com.disney.hero_interactors.GetSingleHeroById
import com.disney.hero_interactors.HeroInteractors
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object HeroDetailModule {

    @Provides
    @Singleton
    fun providesGetSingleHeroFromId( heroInteractors : HeroInteractors
    ) : GetSingleHeroById = heroInteractors.getSingleHeroById

}

