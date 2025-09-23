package com.creator.movieapp.ui.screens.components.slider

import android.icu.text.ListFormatter.Width
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun RoundedRect(
    w: Int = 32,
    h: Int = 10,
    roundedNumber: Int = 100,
    containerColor: Color = Color(0xff12CDD9),
    opacity : Float = 1f
) {
    Box(
        modifier = Modifier
            .width(w.dp)
            .height(h.dp)
            .background(
                containerColor.copy(alpha = opacity),
                shape = RoundedCornerShape(roundedNumber),
                )
    )
}

@Preview
@Composable
private fun RoundedRectPreview() {
    RoundedRect()
}