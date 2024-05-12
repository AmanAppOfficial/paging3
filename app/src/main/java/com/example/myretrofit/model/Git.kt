package com.example.myretrofit.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Git(
    val repository_url: String,
    val number: Int
): Parcelable
