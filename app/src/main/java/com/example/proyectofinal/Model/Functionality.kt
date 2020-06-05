package com.example.proyectofinal.Model

import android.os.Parcel
import android.os.Parcelable

class Functionality(val title: String?, val explanationSteps: List<ExplanationStep>) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            TODO("explanationSteps")) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(title)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Functionality> {
        override fun createFromParcel(parcel: Parcel): Functionality {
            return Functionality(parcel)
        }

        override fun newArray(size: Int): Array<Functionality?> {
            return arrayOfNulls(size)
        }
    }
}