package com.example.apistudiesproject.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.apistudiesproject.data.MovieRepo
import com.example.apistudiesproject.model.MovieModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val movieRepo: MovieRepo
) : ViewModel() {
    private val state = MutableStateFlow(emptyList<MovieModel>())
    val stateFlow: StateFlow<List<MovieModel>>
        get() = state

    init {
        viewModelScope.launch {
            val movies = movieRepo.getMovie()
            state.value = movies
        }
    }
}