package com.creator.movieapp.ui.screens.onboarding.components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.creator.movieapp.R

val CONTENT_COLOR = Color(0xff1F1D2B)
val CONTAINER_COLOR = Color(0xff12CDD9)

@Composable
fun FAB(
    onclick: () -> Unit,
    modifier: Modifier = Modifier,
    fabSize: Int = 60,
    iconWidth: Int = 7,
    iconHeight: Int = 14
) {

    FloatingActionButton(
        onClick = onclick,
        modifier = Modifier
            .size(fabSize.dp),
        containerColor = CONTAINER_COLOR,

    ) {
        Icon(
            painter = painterResource(R.drawable.arrow),
            contentDescription = null,
            modifier = Modifier
                .width(iconWidth.dp)
                .height(iconHeight.dp),
            tint = CONTENT_COLOR

        )
    }
}

@Preview(showBackground = true)
@Composable
private fun FABPreview() {
    FAB({})
}