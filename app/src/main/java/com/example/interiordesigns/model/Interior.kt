package com.example.interiordesigns.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Interior(
   @StringRes val nameRes : Int,
   @StringRes val tipRes : Int,
   @DrawableRes val imageRes : Int,
   @StringRes val descriptionRes : Int,
    )
