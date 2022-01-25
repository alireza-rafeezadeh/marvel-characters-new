package com.disney.hero_interactors

import com.disney.core.Data
import com.disney.core.Loading
import com.disney.core.ProgressBarState
import com.disney.core.Response
import com.disney.hero_datasource_test.network.HeroDataValid.NUM_HEROS
import com.disney.hero_datasource_test.network.HeroServiceFake
import com.disney.hero_datasource_test.network.HeroServiceResponseType
import com.disney.hero_domain.Hero
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.runBlocking
import org.junit.Test

class GetHerosTest {

    // system in test
    private lateinit var getHeros: GetHeros

    @Test
    fun `get heroes valid data should succeed`() =  runBlocking {
        // setup
//        val heroDatabase = HeroDatabaseFake()
//        val heroCache = HeroCacheFake(heroDatabase)
        val heroService = HeroServiceFake.build(
            type = HeroServiceResponseType.GoodData // good data
        )

        getHeros = GetHeros(
//            cache = heroCache,
            service = heroService
        )

        // Confirm the cache is empty before any use-cases have been executed
//        var cachedHeros = heroCache.selectAll()
//        assert(cachedHeros.isEmpty())

        // Execute the use-case
        val emissions = getHeros.execute().toList()

        // First emission should be loading
        assert(emissions[0] == Loading<List<Hero>>(ProgressBarState.Loading))

        // Confirm second emission is data
        assert(emissions[1] is Data)
        assert((emissions[1] as Data).data?.size?: 0 == NUM_HEROS)

        // Confirm the cache is no longer empty
//        cachedHeros = heroCache.selectAll()
//        assert(cachedHeros.size == NUM_HEROS)

        // Confirm loading state is IDLE
//        assert(emissions[2] == Loading<List<Hero>>(ProgressBarState.Idle))
    }

    @Test
    fun `get heroes malformed data should fail`() = runBlocking {

        // setup
//        val heroDatabase = HeroDatabaseFake()
//        val heroCache = HeroCacheFake(heroDatabase)
        val heroService = HeroServiceFake.build(
            type = HeroServiceResponseType.Malformed // good data
        )

        getHeros = GetHeros(
//            cache = heroCache,
            service = heroService
        )

        // Execute the use-case
        val emissions = getHeros.execute().toList()

        // First emission should be loading
        assert(emissions[0] == Loading<List<Hero>>(ProgressBarState.Loading))

        // Confirm second emission is data
        assert(emissions[1] is Response)
    }
}