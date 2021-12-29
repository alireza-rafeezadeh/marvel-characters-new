package com.disney.marvelcharacters

import com.disney.hero_interactors.GetHeros
import com.disney.hero_interactors.HeroInteractors
import com.disney.ui_heroList.di.EmptyTest
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
    fun providesGetHeros(
    ) : GetHeros = HeroInteractors.build().getHeros


    @Provides
    @Singleton
    fun providesEmptyTest(
    ) : EmptyTest = EmptyTest()



}

