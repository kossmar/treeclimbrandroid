package com.markoss.treeclimbrandroid

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by spinkringle on 2018-04-09.
 */
class Photo(): Parcelable {


    var userID: String = ""
    var userName: String = ""
    var photoURL: String = ""
    var timeStamp: String = ""
    var isMain: Boolean = false
    var photoID: String = ""
    var imageDBName: String = ""
    var image: Int = 0

    constructor(parcel: Parcel) : this() {
        userID = parcel.readString()
        userName = parcel.readString()
        photoURL = parcel.readString()
        timeStamp = parcel.readString()
        isMain = parcel.readByte() != 0.toByte()
        photoID = parcel.readString()
        imageDBName = parcel.readString()
        image = parcel.readInt()
    }

    constructor(URL: String) : this() {
        this.photoURL = URL
    }

//    var userID = String()
//    var userName = String()
//    var photoURL : String
//    var timeStamp = String()
//    var isMain : Bool
//    var photoID = String()
//    var imageDBName = String()
//    var image: UIImage?
    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(userID)
        parcel.writeString(userName)
        parcel.writeString(photoURL)
        parcel.writeString(timeStamp)
        parcel.writeByte(if (isMain) 1 else 0)
        parcel.writeString(photoID)
        parcel.writeString(imageDBName)
        parcel.writeInt(image)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Photo> {
        override fun createFromParcel(parcel: Parcel): Photo {
            return Photo(parcel)
        }

        override fun newArray(size: Int): Array<Photo?> {
            return arrayOfNulls(size)
        }
    }

}