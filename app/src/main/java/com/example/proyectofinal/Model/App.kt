package com.example.proyectofinal.Model

import android.os.Parcel
import android.os.Parcelable

class App(val name: String?, val image: String?) : Parcelable {

    constructor(source: Parcel) : this(
            source.readString(),
            source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(name)
        writeString(image)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<App> = object : Parcelable.Creator<App> {
            override fun createFromParcel(source: Parcel): App = App(source)
            override fun newArray(size: Int): Array<App?> = arrayOfNulls(size)
        }
    }
}