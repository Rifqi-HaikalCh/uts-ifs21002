package com.ifs21002.dinopedia

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class Dino (
    var image : Int,
    var text : String
) : Parcelable