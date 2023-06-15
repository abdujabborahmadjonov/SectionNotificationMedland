package dev.abdujabbor.sectionnotificationmedland.retrofit

import dev.abdujabbor.sectionnotificationmedland.models.ModelOfLis
import retrofit2.Call
import retrofit2.http.GET

interface InterfaceMyRetrofitService {
    @GET(value ="plan")
    fun getAllTodo():Call<ArrayList<ModelOfLis>>
}