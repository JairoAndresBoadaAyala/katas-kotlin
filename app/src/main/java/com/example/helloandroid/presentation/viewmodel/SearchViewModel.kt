package com.example.helloandroid.presentation.viewmodel

import com.example.helloandroid.R
import com.example.helloandroid.presentation.Movie

object SearchViewModel {
    val movieItems = arrayListOf(
        Movie(
            R.drawable.apple, "Apple", "2010", "This is a movies of apple"
        ),
        Movie(
            R.drawable.facebook, "Facebook", "2012", "This is a movies of facebook"
        ),
        Movie(
            R.drawable.google, "Google", "2014", "This is a movies of apple"
        ),
        Movie(
            R.drawable.ic_back, "Back", "2017", "this is the movies of back"
        ),
        Movie(
            R.drawable.ic_password_off, "Password", "2020", "this is the movies of Password"
        )
    )
}