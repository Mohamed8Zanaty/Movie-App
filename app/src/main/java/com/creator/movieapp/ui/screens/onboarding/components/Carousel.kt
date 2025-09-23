package com.creator.movieapp.ui.screens.onboarding.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.creator.movieapp.R
import kotlinx.coroutines.delay
import kotlin.math.absoluteValue

val movies = listOf(
    R.drawable.movie_test,
    R.drawable.movie_test,
    R.drawable.movie_test,
)

@Composable
fun Carousel(
    images: List<Int>,
    modifier: Modifier = Modifier,
    itemWidthRatio: Float = 0.65f,
    itemHeight: Dp = 360.dp,
    pageSpacing: Dp = 12.dp,
    autoScroll: Boolean = true,
    pageAnimDurationMs: Int = 700,
    pauseBetweenPagesMs: Long = 300L,

) {
    if (images.isEmpty()) return

    val REAL_IMAGE_COUNT = images.size
    val VIRTUAL_LOOP = 10000
    val pageCount = REAL_IMAGE_COUNT * VIRTUAL_LOOP
    val startPage = (pageCount / 2) - ((pageCount / 2) % REAL_IMAGE_COUNT)
    val pagerState = rememberPagerState(initialPage = startPage, pageCount = { pageCount })
    LaunchedEffect(pagerState, autoScroll, pageAnimDurationMs, pauseBetweenPagesMs) {
        if (!autoScroll || REAL_IMAGE_COUNT == 1) return@LaunchedEffect
        delay(600L)
        while (true) {
            if (!pagerState.isScrollInProgress) {
                val next = pagerState.currentPage + 1
                pagerState.animateScrollToPage(
                    page = next,
                    animationSpec = tween(durationMillis = pageAnimDurationMs)
                )
                delay(pauseBetweenPagesMs)
            } else {
                delay(120L)
            }
        }
    }

    BoxWithConstraints(
        modifier = modifier
            .fillMaxWidth()
            .height(itemHeight)
            .background(Color(0xff171725)),
        contentAlignment = Alignment.Center
    ) {
        val boxWidth = maxWidth
        val itemWidth = boxWidth * itemWidthRatio
        val sidePadding = (boxWidth - itemWidth) / 2

        HorizontalPager(
            state = pagerState,
            pageSpacing = pageSpacing,
            contentPadding = PaddingValues(horizontal = sidePadding),
            modifier = Modifier.fillMaxSize()
        ) { page ->
            val imageIndex = page % REAL_IMAGE_COUNT

            val pageOffset = (pagerState.currentPage + pagerState.currentPageOffsetFraction - page)
                .absoluteValue
                .coerceIn(0f, 1f)

            val targetScale = lerp(0.86f, 1f, 1f - pageOffset)
            val scale by animateFloatAsState(targetValue = targetScale, animationSpec = tween(300))

            val targetTranslationY = lerp(20f, 0f, 1f - pageOffset)
            val animTranslationY by animateFloatAsState(targetValue = targetTranslationY, animationSpec = tween(300))

            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .width(itemWidth)
                    .graphicsLayer {
                        scaleX = scale
                        scaleY = scale
                        translationY = animTranslationY
                    }
                    .clip(RoundedCornerShape(18.dp))
                    .shadow(8.dp, RoundedCornerShape(18.dp))
            ) {
                Image(
                    painter = painterResource(id = images[imageIndex]),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(RoundedCornerShape(18.dp))
                )
            }
        }
    }
}


private fun lerp(start: Float, stop: Float, fraction: Float): Float =
    start + (stop - start) * fraction

@Preview(showBackground = true, backgroundColor = 0xFF121217)
@Composable
fun CarouselPreview() {


    Surface(color = Color(0xFF11121A), modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Carousel(
                images = movies,
                pageAnimDurationMs = 2000,
                pauseBetweenPagesMs = 700L
            )
        }
    }
}
