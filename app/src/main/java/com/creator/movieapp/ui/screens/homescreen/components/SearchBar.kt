package com.creator.movieapp.ui.screens.homescreen.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview


@Composable
fun SearchBar(query: String, onQueryChange: (String) -> Unit) {
    var q = remember { mutableStateOf(query) }
    TextField(

        value = q.value,
        onValueChange = {
            q.value = it
            onQueryChange(it)
        },
        placeholder = { Text("Search", color = Color(0xFF8C9096)) },
        leadingIcon = { Icon(Icons.Default.Search, contentDescription = "Search icon", tint = Color(0xFF8C9096)) },
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color(0xFF1A1F23),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            cursorColor = Color.White,
            textColor = Color.White
        ),
        modifier = Modifier
            .fillMaxWidth()
            .height(64.dp)
            .clip(RoundedCornerShape(12.dp)),
    )
}

@Preview
@Composable
private fun SearchBarPreview() {
    SearchBar("", {})
}