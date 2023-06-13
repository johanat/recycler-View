package com.example.recyclerViewExample.norrisJokes

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface APIService {
    @GET
    suspend fun getNorrisJoke(@Url url:String):Response<NorrisJokeResponse> /* esta funcion definira el tipo  de consumo de API
                                                                            y lo que nos va a devolver */
}