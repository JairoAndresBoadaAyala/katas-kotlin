package com.example.helloandroid.ui.theme.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.helloandroid.R

@Composable
fun Header(modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(id = R.drawable.ic_logo_app),
        contentDescription = null,
        modifier = modifier
    )
}