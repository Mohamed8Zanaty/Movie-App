package com.creator.movieapp.ui.screens.homescreen.components
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.creator.movieapp.R

@Composable
fun BottomNavBar() {
    val selected = remember { mutableStateOf(0) }
    BottomNavigation(
        modifier = Modifier.padding(24.dp),
        backgroundColor = Color(0xff242A32),

    ) {
        BottomNavigationItem(
            icon = { Icon(
                painter = painterResource(R.drawable.home),
                contentDescription = null,
                modifier = Modifier.size(24.dp)
            ) },
            selected = selected.value == 0,
            onClick = { selected.value = 0 },
            selectedContentColor = Color(0xFF0296E5),
            unselectedContentColor = Color(0xFF7A7E83)
        )
        BottomNavigationItem(
            icon = { Icon(
                painter = painterResource(R.drawable.search),
                contentDescription = null,
                modifier = Modifier.size(24.dp)
            ) },
            selected = selected.value == 1,
            onClick = { selected.value = 1 },
            selectedContentColor = Color(0xFF0296E5),
            unselectedContentColor = Color(0xFF7A7E83)
        )
        BottomNavigationItem(
            icon = { Icon(
                painter = painterResource(R.drawable.save),
                contentDescription = null,
                modifier = Modifier.size(24.dp)
            ) },
            selected = selected.value == 2,
            onClick = { selected.value = 2 },
            selectedContentColor = Color(0xFF0296E5),
            unselectedContentColor = Color(0xFF7A7E83)
        )
    }
}

@Preview
@Composable
private fun BottomNavBarPreview() {
    BottomNavBar()
}