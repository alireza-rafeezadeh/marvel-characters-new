package com.disney.hero_datasource_test.network

sealed class HeroServiceResponseType {
    object EmptyList : HeroServiceResponseType()
    object Malformed : HeroServiceResponseType()
    object GoodData : HeroServiceResponseType()
    object Http404 : HeroServiceResponseType()

}
