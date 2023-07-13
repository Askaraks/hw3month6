package com.example.hw3month6.ui.playlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.hw3month6.core.base.BaseViewModel
import com.example.hw3month6.core.network.Resourse
import com.example.hw3month6.data.model.PlayListsModel
import com.example.hw3month6.repository.Repository

class PlayListViewModel: BaseViewModel() {


    private val repo = Repository()
    var livedata : LiveData<Resourse<PlayListsModel>> = MutableLiveData()

    fun getPlayList() {
        livedata = repo.getPlayLists()
    }
}