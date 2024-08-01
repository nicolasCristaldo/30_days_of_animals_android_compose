package com.nicolascristaldo.a30daysofanimals.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Animal(
    @DrawableRes val image: Int,
    @StringRes val name: Int,
    @StringRes val description: Int
)
