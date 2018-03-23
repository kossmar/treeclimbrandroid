package com.markoss.treeclimbrandroid

import android.util.ArraySet
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

/**
 * Created by spinkringle on 2018-03-22.
 */
class AppData {

    companion object SharedInstance {

        val databaseRef: DatabaseReference = FirebaseDatabase.getInstance().reference


        var treesArray = arrayListOf<Tree>()
        var treesNode = databaseRef!!.child("trees")


    }
}