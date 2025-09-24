package com.creator.movieapp.model.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

open class MovieViewModel(private val repo: MovieRepository) : ViewModel() {
    private val _featured = MutableStateFlow<List<Movie>>(emptyList())
    val featured: StateFlow<List<Movie>> = _featured.asStateFlow()

    private val _grid = MutableStateFlow<List<Movie>>(emptyList())
    val grid: StateFlow<List<Movie>> = _grid.asStateFlow()

    private val _query = MutableStateFlow("")
    val query: StateFlow<String> = _query.asStateFlow()

    init {
        loadNowPlaying(30)
    }

    fun loadNowPlaying(count: Int) {
        viewModelScope.launch {
            try {
                _featured.value = repo.getNowPlaying().take(4)
                _grid.value = repo.getNowPlaying().take(count)
            } catch (e: Exception) { e.printStackTrace() }
        }
    }

    fun loadUpcoming(count: Int) {
        viewModelScope.launch {
            try {
                _grid.value = repo.getUpcoming().take(count)
            } catch (e: Exception) { e.printStackTrace() }
        }
    }

    fun loadTopRated(count: Int) {
        viewModelScope.launch {
            try {
                _grid.value = repo.getTopRated().take(count)
            } catch (e: Exception) { e.printStackTrace() }
        }
    }

    fun loadPopular(count: Int) {
        viewModelScope.launch {
            try {
                _grid.value = repo.getPopular().take(count)
            } catch (e: Exception) { e.printStackTrace() }
        }
    }

    fun onQueryChanged(q: String) {
        _query.value = q
        if (q.length >= 3) {
            viewModelScope.launch {
                try {
                    _grid.value = repo.search(q)
                } catch (e: Exception) { e.printStackTrace() }
            }
        } else {
            loadNowPlaying(30)
        }
    }
    class Factory(private val repo: MovieRepository) : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return MovieViewModel(repo) as T
        }
    }
}