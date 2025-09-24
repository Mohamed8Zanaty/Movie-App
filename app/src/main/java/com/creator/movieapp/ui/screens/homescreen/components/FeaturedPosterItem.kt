package com.creator.movieapp.ui.screens.homescreen.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.creator.movieapp.api.IMAGE_BASE
import com.creator.movieapp.model.movie.Movie


@Composable
fun FeaturedPosterItem(movie: Movie, index: Int, onClick: () -> Unit) {
    val numberText = "${index + 1}"
    var pressed by remember { mutableStateOf(false) }
    val scale by animateFloatAsState(if (pressed) 0.97f else 1f)

Box(
    modifier = Modifier
        .width(200.dp)
        .height(275.dp)
        .graphicsLayer { scaleX = scale; scaleY = scale }
        .background(Color.Transparent)
) {

    Box(
        modifier = Modifier
            .width(170.dp)
            .height(240.dp)
            .graphicsLayer { scaleX = scale; scaleY = scale }
            .clip(RoundedCornerShape(16.dp))
            .background(Color(0xFF151A1D))
            .clickable {
                pressed = true
                onClick()
                pressed = false
            }
            .shadow(6.dp, RoundedCornerShape(16.dp))
            .align(Alignment.TopCenter)
    ) {
        AsyncImage(
            model = IMAGE_BASE + (movie.posterPath ?: ""),
            contentDescription = movie.title,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )




    }
        Text(
            text = numberText,
            color = Color(0xff0296E5),
            fontSize = 96.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .align(Alignment.BottomStart)

        )
}
}

@Preview
@Composable
private fun FeaturedPosterItemPreview() {
    FeaturedPosterItem(
        Movie(1, "Inception", "/qmDpIHrmpJINaRKAfWQfftjCdyi.jpg", "2010-07-16", 8.3f),
        1,
    ) { }
}