package com.firesoftwaregroup.itunessearchapi.network


import com.firesoftwaregroup.itunessearchapi.network.response.SearchResultResponse
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Query
import retrofit2.http.Url

interface APIInterface {

    @GET("/search")
    fun searchByTerm(@Query("term") term: String): Call<SearchResultResponse>

}

