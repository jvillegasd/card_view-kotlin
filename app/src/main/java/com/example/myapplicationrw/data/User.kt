package com.example.myapplicationrw.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User (val nombre: String, val apellido: String, val email: String, val telefono: String, val titulo: String) :
    Parcelable {

}