package com.markoss.treeclimbrandroid

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import javax.security.auth.callback.Callback

/**
 * Created by spinkringle on 2018-04-11.
 */
object PhotoManager {

    fun loadPhotos(tree: Tree, callback: (ArrayList<Photo>) -> Unit) {


        var tempPhotoArray = ArrayList<Photo>()

        AppData.photosNode.child(tree.treeID).addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onDataChange(dataSnapshot: DataSnapshot?) {
                if (dataSnapshot!!.exists()) {
                    for (t in dataSnapshot.children) {
                        val photoDictionary = t.value as HashMap<String, String>
                        val userID: String = photoDictionary["userIDKey"] as String
                        val userName: String = photoDictionary["userNameKey"] as String
                        val photoURL: String = photoDictionary["urlKey"] as String
                        val timeStamp: String = photoDictionary["timeKey"] as String
                        val isMain: String = photoDictionary["isMainKey"] as String
                        val photoID: String = photoDictionary["photoIDKey"] as String
                        val imageDBName: String = photoDictionary["imageDBNameKey"] as String

                        var readPhoto = Photo(photoURL)
                        readPhoto.userID = userID
                        readPhoto.userName = userName
                        readPhoto.timeStamp = timeStamp
                        readPhoto.isMain = isMain as Boolean
                        readPhoto.photoID = photoID
                        readPhoto.imageDBName = imageDBName

                        tempPhotoArray.add(readPhoto)
                    }
                    callback(tempPhotoArray)
                }
            }
        })
    }
}