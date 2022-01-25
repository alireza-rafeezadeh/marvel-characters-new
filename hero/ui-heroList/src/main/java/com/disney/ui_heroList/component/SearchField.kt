package com.disney.ui_heroList.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.disney.ui_heroList.R


@Composable
fun SearchField(text: String, onValueTextChanged: (str: String) -> Unit) {
    TextField(
        value = text,
        onValueChange = {
            onValueTextChanged(it)
        },
        label = { Text("AquaMan") },
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp), shape = RoundedCornerShape(8.dp),
        trailingIcon = {
            Icon(Icons.Filled.Search, "", tint = colorResource(id = R.color.red))

        },
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = colorResource(id = R.color.card_background),
            focusedIndicatorColor = Color.Transparent, //hide the indicator
            unfocusedIndicatorColor = Color.Transparent
        )


    )
}