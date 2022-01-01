package com.disney.marvelcharacters.di.heroList

import com.disney.hero_interactors.GetHeros
import com.disney.hero_interactors.HeroInteractors
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object HeroListModule {

    @Provides
    @Singleton
    fun providesGetHeros( heroInteractors : HeroInteractors
    ) : GetHeros = heroInteractors.getHeros

}

