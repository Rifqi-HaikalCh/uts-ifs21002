package com.ifs21002.dinopedia

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Fruit(
    var name: String,
    var icon: Int,
    var description: String,
    var characteristic: String,
    var habitat: String,
) : Parcelable