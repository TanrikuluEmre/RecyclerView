package com.firesoftwaregroup.itunessearchapi.network.response

data class SearchResultResponse(val resultCount: Int,val results:List<ResultDataVariables>)
data class ResultDataVariables(val artistName:String,
                               val collectionName:String,
                               val trackName:String,
                               val collectionPrice:Double,
                               val releaseDate:String,
                               val artworkUrl100:String,
                               val currency:String)
