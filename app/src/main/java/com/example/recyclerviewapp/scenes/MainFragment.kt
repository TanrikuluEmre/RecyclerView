package com.example.recyclerviewapp.scenes

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewapp.Network.Network.service
import com.example.recyclerviewapp.R
import com.firesoftwaregroup.itunessearchapi.network.response.ResultDataVariables
import com.firesoftwaregroup.itunessearchapi.network.response.SearchResultResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainFragment : Fragment() {
    private lateinit var searchBar: EditText
    private lateinit var button: Button
    private val mainFragmentViewModel: MainFragmentViewModel = MainFragmentViewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {}
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        searchBar = view.findViewById(R.id.searchBar)
        button = view.findViewById(R.id.searchButton)

        button.setOnClickListener {
            val term = searchBar.text.toString()

            mainFragmentViewModel.doSearchByTerm(term){ result ->
                setupAdapter(result)
            }

        }
    }

    private fun setupAdapter(result: List<ResultDataVariables>?) {
        val customerAdapter = CityAdapter(result)
        val recyclerView: RecyclerView? = view?.findViewById(R.id.recyclerView)
        recyclerView?.layoutManager = LinearLayoutManager(activity)
        recyclerView?.adapter = customerAdapter
    }

//    private fun doSearchByTerm(term: String) {
//        service.searchByTerm(term).enqueue(object : Callback<SearchResultResponse> {
//            override fun onResponse(call: Call<SearchResultResponse>, response: Response<SearchResultResponse>) {
//                if (response.isSuccessful && response.body() != null) {
//                    val result = response.body()?.results
//                    setupAdapter(result)
//                    Log.d(tag, "$term result count ${response.body()?.resultCount}")
//                } else {
//                    Log.e(tag, "Error onResponse")
//                }
//            }
//
//            override fun onFailure(call: Call<SearchResultResponse>, t: Throwable) {
//                Log.e(tag, "Error onFailure")
//            }
//        })
//    }

    companion object {
        @JvmStatic
        fun newInstance() =
            MainFragment().apply {
                arguments = Bundle().apply {}
            }
    }
}
