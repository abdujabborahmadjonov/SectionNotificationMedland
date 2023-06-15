package dev.abdujabbor.sectionnotificationmedland.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    private const val BASEURL = "https://hvax.pythonanywhere.com/"

    private fun getRetrofit(): Retrofit {

        return Retrofit.Builder()
            .baseUrl(BASEURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun getApiService(): InterfaceMyRetrofitService {
        return  getRetrofit().create(InterfaceMyRetrofitService::class.java)
    }
}