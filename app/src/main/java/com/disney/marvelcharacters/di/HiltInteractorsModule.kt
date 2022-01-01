package com.disney.marvelcharacters.di

import com.disney.hero_interactors.HeroInteractors
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class )
object HiltInteractorsModule {


    @Provides
    @Singleton
    fun provideAndroidDriver() : HeroInteractors {
        return HeroInteractors.build()
    }

}