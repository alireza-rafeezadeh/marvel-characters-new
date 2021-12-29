package com.disney.marvelcharacters

import android.util.Log
import com.disney.hero_interactors.GetHeros
import javax.inject.Inject


class MyNewViewModel @Inject constructor(
    val getHeros : GetHeros
) {

    fun test() {
        Log.i("dagger_work", "hilt works! ")
    }
}