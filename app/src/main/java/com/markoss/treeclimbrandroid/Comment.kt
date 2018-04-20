package com.markoss.treeclimbrandroid

import android.os.Parcel
import android.os.Parcelable
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.time.Instant
import java.time.LocalDateTime
import java.time.LocalDateTime.*
import java.util.*

/**
 * Created by spinkringle on 2018-04-19.
 */
class Comment() : Parcelable {

    var body: String = ""
    var timeStamp: String = ""
    var userID: String = ""
    var userName: String = ""
    var commentID: String = ""

    constructor(parcel: Parcel) : this() {
        body = parcel.readString()
        timeStamp = parcel.readString()
        userID = parcel.readString()
        userName = parcel.readString()
        commentID = parcel.readString()
    }

    constructor(body: String): this() {

        val date = Date()
        val dateFormatter : SimpleDateFormat = SimpleDateFormat()
        dateFormatter.applyPattern("MM-dd-yyyy HH:mm:ss")
        val dateStr: String = dateFormatter.format(date)
        this.timeStamp = dateStr
        this.body = body
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(body)
        parcel.writeString(timeStamp)
        parcel.writeString(userID)
        parcel.writeString(userName)
        parcel.writeString(commentID)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Comment> {
        override fun createFromParcel(parcel: Parcel): Comment {
            return Comment(parcel)
        }

        override fun newArray(size: Int): Array<Comment?> {
            return arrayOfNulls(size)
        }
    }

}