package com.example.recyclerviewapp.scenes

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.recyclerviewapp.Network.Network.service
import com.firesoftwaregroup.itunessearchapi.network.response.ResultDataVariables
import com.firesoftwaregroup.itunessearchapi.network.response.SearchResultResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainFragmentViewModel{
    private var result : List<ResultDataVariables>? = null

    fun doSearchByTerm(term: String, myCallback: (result:List<ResultDataVariables>?) -> Unit) {
        service.searchByTerm(term).enqueue(object : Callback<SearchResultResponse> {
            override fun onResponse(call: Call<SearchResultResponse>, response: Response<SearchResultResponse>) {
                if (response.isSuccessful && response.body() != null) {
                    result = response.body()?.results
                    myCallback.invoke(result)
                } else {
                    myCallback.invoke(null)
                }
            }

            override fun onFailure(call: Call<SearchResultResponse>, t: Throwable) {
                myCallback.invoke(null)
            }
        })

    }
}