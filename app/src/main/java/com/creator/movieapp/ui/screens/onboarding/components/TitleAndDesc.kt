package com.creator.movieapp.ui.screens.onboarding.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.fontResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.creator.movieapp.R

val MyFontFamily = FontFamily(
    Font(R.font.montserrat_regular, weight = FontWeight.Normal),
    Font(R.font.montserrat_bold,    weight = FontWeight.Bold),
    Font(R.font.montserrat_semibold, weight = FontWeight.SemiBold),
    Font(R.font.montserrat_medium, weight = FontWeight.Medium)
)

@Composable
fun TitleAndDesc(
    title: String,
    desc: String,
    width: Int = 264
) {
    Column(
        modifier = Modifier
            .width(width.dp)
    ) {
        Text(
            text = title,
            fontSize = 18.sp,
            color = Color.White,
            fontWeight = FontWeight.SemiBold,
            fontFamily = MyFontFamily,
            letterSpacing = 0.12.sp,
            textAlign = TextAlign.Center,
            lineHeight = 30.sp

        )
        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = desc,
            fontSize = 14.sp,
            color = Color(0xff92929D),
            fontWeight = FontWeight.Medium,
            fontFamily = MyFontFamily,
            letterSpacing = 0.12.sp,
            textAlign = TextAlign.Center,

        )

    }
}

@Preview(
    showBackground = true,
    backgroundColor = 0xff171725
)
@Composable
private fun TitleAndDescPreview() {
    TitleAndDesc(
        "Lorem ipsum dolor sit amet consecteur esplicit",
        "Semper in cursus magna et eu varius nunc adipiscing. Elementum justo, laoreet id sem semper parturient. "
    )
}