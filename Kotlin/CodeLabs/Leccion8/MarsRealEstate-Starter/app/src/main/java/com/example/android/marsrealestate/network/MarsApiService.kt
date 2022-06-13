/*
 * Copyright 2019, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.example.android.marsrealestate.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

private const val BASE_URL = "https://android-kotlin-fun-mars-server.appspot.com/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

//Creamos un objeto Retrofit
private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

/*Esta interfaz define cómo Retrofit se comunica con el servidor web.
* - realstate es el punto final de la url después de la última barra de la URL base
* - Con getProperties() obtenemos la cadena de respuesta JSON
* - El objeto Call inicia la solicitud
* */
interface MarsApiService {
    @GET("realestate")
    //este objeto inicia la solicitud. Query le dice a la función que haga la petición con ? en la url
    suspend fun getProperties(@Query("filter") type: String): List<MarsProperty>
}

/* Este objeto inicializa el servicio Retrofit
*  Cada vez que su aplicación llame MarsApi.retrofitServicea ,
*  obtendrá un objeto Singleton Retrofit que implementa MarsApiService.
* */
object MarsApi {
    val retrofitService : MarsApiService by lazy {
        retrofit.create(MarsApiService::class.java) }
}

//Esta clase nos ayuda con los filtros de las peticiones
enum class MarsApiFilter(val value: String) {
    SHOW_RENT("rent"),
    SHOW_BUY("buy"),
    SHOW_ALL("all") }
