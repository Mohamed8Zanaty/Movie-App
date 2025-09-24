package com.creator.movieapp.ui.screens.homescreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.Text
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.creator.movieapp.R
import com.creator.movieapp.model.movie.Movie
import com.creator.movieapp.model.movie.MovieViewModel
import com.creator.movieapp.ui.screens.homescreen.components.BottomNavBar
import com.creator.movieapp.ui.screens.homescreen.components.FeaturedPosterItem
import com.creator.movieapp.ui.screens.homescreen.components.PosterGridItem
import com.creator.movieapp.ui.screens.homescreen.components.SearchBar
import com.creator.movieapp.ui.screens.homescreen.components.TabRowNow

val MyFontFamily = FontFamily(
    Font(R.font.montserrat_regular, weight = FontWeight.Normal),
    Font(R.font.montserrat_bold,    weight = FontWeight.Bold),
    Font(R.font.montserrat_semibold, weight = FontWeight.SemiBold),
    Font(R.font.montserrat_medium, weight = FontWeight.Medium)
)
@Composable
fun HomeScreenContent(
    featured: List<Movie>,
    grid: List<Movie>,
    query: String,
    onQueryChange: (String) -> Unit,
    selectedTab: Int,
    onTabSelected: (Int) -> Unit,
    onPosterClick: (Movie) -> Unit = {},
    onFeaturedClick: (Movie) -> Unit = {}
) {
    Scaffold(
        bottomBar = { BottomNavBar() }
    ) {
        Column(
            modifier = Modifier
                .background(Color(0xff242A32))
                .padding(it)
                .padding(horizontal = 16.dp)
                .fillMaxSize()
        ) {
            Spacer(Modifier.height(18.dp))
            Text(
                text = "What do you want to watch?",
                style = MaterialTheme.typography.h6,
                color = Color.White,
                fontWeight = FontWeight.SemiBold,
                fontFamily = MyFontFamily
            )
            Spacer(Modifier.height(24.dp))
            SearchBar(query = query, onQueryChange = onQueryChange)
            Spacer(Modifier.height(20.dp))

            // featured row
            LazyRow(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                items(featured.size) { idx ->
                    FeaturedPosterItem(
                        movie = featured[idx],
                        index = idx,
                        onClick = { onFeaturedClick(featured[idx]) })
                }
            }

            Spacer(Modifier.height(18.dp))
            TabRowNow(selectedIndex = selectedTab, onTabSelected = { onTabSelected(it) })
            Spacer(Modifier.height(12.dp))

            LazyVerticalGrid(
                columns = GridCells.Fixed(3),
                contentPadding = PaddingValues(bottom = 80.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(grid) { movie ->
                    PosterGridItem(movie = movie, onClick = { onPosterClick(movie) })
                }
            }
        }
    }
}

@Composable
fun HomeScreen(viewModel: MovieViewModel, navHostController: NavHostController) {
    val featured by viewModel.featured.collectAsState()
    val grid by viewModel.grid.collectAsState()
    val query by viewModel.query.collectAsState()

    var selectedTab by remember { mutableIntStateOf(0) }

    // delegate to the stateless content
    HomeScreenContent(
        featured = featured,
        grid = grid,
        query = query,
        onQueryChange = viewModel::onQueryChanged,
        selectedTab = selectedTab,
        onTabSelected = { index ->
            selectedTab = index
            when (index) {
                0 -> viewModel.loadNowPlaying(30)
                1 -> viewModel.loadUpcoming(30)
                2 -> viewModel.loadTopRated(30)
                3 -> viewModel.loadPopular(30)
            }
        },
        onPosterClick = { /* navigate */ },
        onFeaturedClick = { /* navigate */ }
    )
}

@Preview(showSystemUi = true)
@Composable
fun HomeScreenPreview() {
    // small sample poster paths (TMDB style). In Preview remote images might not load,
    // but layout will still render. You can replace posterPath with local drawables if needed.
    val sampleFeatured = listOf(
        Movie(1, "Inception", "/qmDpIHrmpJINaRKAfWQfftjCdyi.jpg", "2010-07-16", 8.3f),
        Movie(2, "Interstellar", "/gEU2QniE6E77NI6lCU6MxlNBvIx.jpg", "2014-11-05", 8.1f)
    )

    val sampleGrid = listOf(
        Movie(3, "Tenet", "/k68nPLbIST6NP96JmTxmZijEvCA.jpg", "2020-08-26", 7.4f),
        Movie(4, "Dunkirk", "/ebSnODDg9lbsMIaWg2uAbjn7TO5.jpg", "2017-07-21", 7.9f),
        Movie(5, "The Dark Knight", "/qJ2tW6WMUDux911r6m7haRef0WH.jpg", "2008-07-16", 9.0f),
        Movie(6, "Memento", "/9XjZS2x5rQdJv5D0v3t6Q7YwFvO.jpg", "2000-09-05", 8.0f),
        Movie(7, "Prestige", "/bAU3l0jXJ8J5c2dfuT8jX0XqN9J.jpg", "2006-10-20", 7.7f)
    )

    HomeScreenContent(
        featured = sampleFeatured,
        grid = sampleGrid,
        query = "",
        onQueryChange = {},
        selectedTab = 0,
        onTabSelected = {}
    )
}



