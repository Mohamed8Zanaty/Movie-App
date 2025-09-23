package com.creator.movieapp.ui.screens.onboarding.components

import android.graphics.fonts.Font
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource

import androidx.compose.ui.text.font.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.creator.movieapp.R

val fontFamily = listOf(
    Font(R.font.montserrat_semibold, weight = FontWeight.SemiBold)
)
@Composable
fun FloatingBox(
    modifier: Modifier = Modifier,
    icon: Int,
    title: String,
    text: String
) {
    Column(
        modifier = modifier
            .width(80.dp)
            .background(Color.Transparent)
            .border(
                width = 0.5.dp,
                color = Color(0xff92929D),
                shape = RoundedCornerShape(15.dp)
            )
            .padding(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            painter = painterResource(icon),
            contentDescription = null,
            tint = Color(0xff12CDD9),
            modifier = Modifier
                .size(16.dp)
        )
        Text(
            text = title,
            color = Color(0xff92929D),
            fontSize = 12.sp,
            fontFamily = FontFamily(fontFamily),
            fontWeight = FontWeight.SemiBold
        )
        Text(
            text = text,
            color = Color.White,
            fontSize = 12.sp,
            fontFamily = FontFamily(fontFamily),
            fontWeight = FontWeight.Bold
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xff1B1B28)
@Composable
private fun FloatingBoxPreview() {
    FloatingBox(
        icon = R.drawable.star,
        title = "Rating",
        text = "9 / 10"

    )
}