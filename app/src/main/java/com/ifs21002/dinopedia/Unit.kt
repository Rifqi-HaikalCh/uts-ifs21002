package com.ifs21002.dinopedia

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Unit(
    var name: String,
    var icon: Int,
    var description: String,
    var characteristic: String,
    var habitat: String,
    var kelemahan: String,
    var tinggi: String,
    var panjang: String,
    var bobot: String,
    var makanan: String,
    var kelompok: String,
) : Parcelable