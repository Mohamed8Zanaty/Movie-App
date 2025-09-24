package com.creator.movieapp.ui.screens.homescreen.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.creator.movieapp.api.IMAGE_BASE
import com.creator.movieapp.model.movie.Movie


@Composable
fun PosterGridItem(movie: Movie, onClick: () -> Unit) {
    var pressed by remember { mutableStateOf(false) }
    val scale by animateFloatAsState(if (pressed) 0.98f else 1f)


    Box(
        modifier = Modifier
            .height(140.dp)
            .clip(RoundedCornerShape(12.dp))
            .graphicsLayer { scaleX = scale; scaleY = scale }
            .background(Color(0xFF151A1D))
            .clickable {
                pressed = true
                onClick()
                pressed = false
            }
    ) {
        AsyncImage(
            model = IMAGE_BASE + (movie.posterPath ?: ""),
            contentDescription = movie.title,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
    }
}