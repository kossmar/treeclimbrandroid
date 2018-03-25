package com.markoss.treeclimbrandroid

import android.util.Log
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import java.net.URL
import java.util.HashMap

/**
 * Created by spinkringle on 2018-03-22.
 */
object TreeManager {

    fun loadTrees(){

        AppData.treesNode.addListenerForSingleValueEvent(object : ValueEventListener {

            override fun onDataChange(dataSnapshot: DataSnapshot?) {

                if (dataSnapshot!!.exists()) {
                    for (t in dataSnapshot.children) {
                        val treeDictionary = t.value as HashMap<String, String>
                        val treeName:String = treeDictionary["nameKey"] as String
                        val treeDescription:String = treeDictionary["descriptionKey"] as String
                        val treeLatitude:Double = treeDictionary["latitudeKey"] as Double
                        val treeLongitude:Double = treeDictionary["longitudeKey"] as Double
                        val treeID:String = treeDictionary["idKey"] as String
//                        val treeHowToFind:String = treeDictionary["howToFindKey"] as String
//                        val treePopularity:Int = treeDictionary["popularityKey"] as Int
//                        val treeRating:Double = treeDictionary["ratingKey"] as Double
//                        val treeSpecies:String = treeDictionary["speciesKey"] as String
//                        val treeCreator:String = treeDictionary["creatorKey"] as String
//                        val treeCreatorName:String = treeDictionary["creatorNameKey"] as String
                        val treePhotoURL: String = treeDictionary["photoKey"] as String

                        val readTree = Tree(name = treeName,
                                description = treeDescription,
                                treeLat = treeLatitude,
                                treeLong = treeLongitude)
                        readTree.treeID = treeID
                        readTree.treePhoto = R.drawable.sometree3
//                        readTree.treeHowToFind = treeHowToFind
//                        readTree.treePopularity = treePopularity
//                        readTree.treeRating = treeRating
//                        readTree.treeSpecies = treeSpecies
//                        readTree.treeCreator = treeCreator
//                        readTree.treeCreatorName = treeCreatorName
                        readTree.treePhotoURL = treePhotoURL
                        AppData.SharedInstance.treesArray.add(readTree)
                    }
                }

            }


            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
            }
        })
    }
}