package com.creator.movieapp.ui.screens.components.slider

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun Slider(
    width: Int = 76,
    number: Int = 1
) {
    when(number) {
        1 -> Slider1(width)
        2 -> Slider2(width)
        3 -> Slider3(width)
    }
}


@Preview(
    showBackground = true,
    backgroundColor = 0xff171725
)
@Composable
private fun SliderPreview() {
    Slider(number = 3)
}

@Composable
fun Slider1(
    width: Int
) {
    Row(
        modifier = Modifier
            .width(width.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        RoundedRect()
        RoundedRect(
            w = 10,
            h = 10,
            roundedNumber = 100,
            opacity = 0.4f
        )
        RoundedRect(
            w = 10,
            h = 10,
            roundedNumber = 100,
            opacity = 0.4f
        )
    }
}

@Composable
fun Slider2(
    width: Int
) {
    Row(
        modifier = Modifier
            .width(width.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        RoundedRect(
            w = 10,
            h = 10,
            roundedNumber = 100,
            opacity = 0.4f
        )
        RoundedRect()
        RoundedRect(
            w = 10,
            h = 10,
            roundedNumber = 100,
            opacity = 0.4f
        )
    }
}

@Composable
fun Slider3(
    width: Int
) {
    Row(
        modifier = Modifier
            .width(width.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        RoundedRect(
            w = 10,
            h = 10,
            roundedNumber = 100,
            opacity = 0.4f
        )
        RoundedRect(
            w = 10,
            h = 10,
            roundedNumber = 100,
            opacity = 0.4f
        )
        RoundedRect()
    }
}

