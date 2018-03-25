package com.markoss.treeclimbrandroid

import android.os.Parcel
import android.os.Parcelable
import android.provider.ContactsContract
import java.net.URL
import java.time.LocalDateTime

/**
 * Created by spinkringle on 2018-03-21.
 */
class Tree() : Parcelable {

    var treeName: String = ""
    var treeSpecies: String = "none"
    var treeRating: Double = 0.0
    var treeDescription: String = ""
    var treeHowToFind: String = ""
    var treeLatitude = 0.0
    var treeLongitude = 0.0
    var treePopularity: Int = 0
    //    var treePhotoData: NSData?
    var treePhoto: Int = 0
    var treePhotoURL:String = ""
    var treeCreator: String = ""
    var treeCreatorName: String = ""
//        var treeComments = Array<Comment>()
    var distFromUser = Double
    var isHidden: Boolean = false
    var treeID: String = ""//treeName + "|" + LocalDateTime.now() + "1"

    constructor(parcel: Parcel) : this() {
        treeName = parcel.readString()
        treeSpecies = parcel.readString()
        treeRating = parcel.readDouble()
        treeDescription = parcel.readString()
        treeHowToFind = parcel.readString()
        treeLatitude = parcel.readDouble()
        treeLongitude = parcel.readDouble()
        treePopularity = parcel.readInt()
        treePhoto = parcel.readInt()
        treePhotoURL = parcel.readString()
        treeCreator = parcel.readString()
        treeCreatorName = parcel.readString()
        isHidden = parcel.readByte() != 0.toByte()
        treeID = parcel.readString()
    }

    constructor(name: String, description: String, treeLat: Double, treeLong: Double) : this() {
        this.treeName = name
        this.treeDescription = description
        this.treeLatitude = treeLat
        this.treeLongitude = treeLong


    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(treeName)
        parcel.writeString(treeSpecies)
        parcel.writeDouble(treeRating)
        parcel.writeString(treeDescription)
        parcel.writeString(treeHowToFind)
        parcel.writeDouble(treeLatitude)
        parcel.writeDouble(treeLongitude)
        parcel.writeInt(treePopularity)
        parcel.writeInt(treePhoto)
        parcel.writeString(treePhotoURL)
        parcel.writeString(treeCreator)
        parcel.writeString(treeCreatorName)
        parcel.writeByte(if (isHidden) 1 else 0)
        parcel.writeString(treeID)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Tree> {
        override fun createFromParcel(parcel: Parcel): Tree {
            return Tree(parcel)
        }

        override fun newArray(size: Int): Array<Tree?> {
            return arrayOfNulls(size)
        }
    }
}