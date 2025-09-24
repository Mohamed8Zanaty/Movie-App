package com.creator.movieapp.ui.screens.homescreen.components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.TabRowDefaults
import androidx.compose.material.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview


@Composable
fun TabRowNow(selectedIndex: Int, onTabSelected: (Int) -> Unit) {
    val tabs = listOf("Now playing", "Upcoming", "Top rated", "Popular")
    TabRow(
        modifier = Modifier.height(30.dp),
        selectedTabIndex = selectedIndex,
        backgroundColor = Color.Transparent,
        contentColor = Color.White,
        indicator = { tabPositions ->
            TabRowDefaults.Indicator(
                Modifier.tabIndicatorOffset(tabPositions[selectedIndex]).padding(top = 10.dp),
                color = Color(0xFF0296E5),
                height = 3.dp
            )
        }
    ) {
        tabs.forEachIndexed { i, title ->
            Tab(selected = selectedIndex == i, onClick = { onTabSelected(i) }) {
                Text(text = title, color = if (selectedIndex == i) Color.White else Color(0xFF8C9096))
            }
        }
    }
}

@Preview
@Composable
private fun TabRowNowPreview() {
    TabRowNow(0, {})
}