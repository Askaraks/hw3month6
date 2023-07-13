package com.example.hw3month6.data.remote

import com.example.hw3month6.data.model.PlayListsModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiServise {

    @GET("playlists")
    fun getPlayLists(
        @Query("part") part: String,
        @Query("channelId") channelId: String,
        @Query("key") apiKey: String,
        @Query("maxResults") maxResults : Int = 10
    ) : Call<PlayListsModel>
}