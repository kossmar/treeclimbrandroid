package com.markoss.treeclimbrandroid

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener

/**
 * Created by spinkringle on 2018-03-22.
 */
object TreeManager {

    public fun loadTrees(){


        AppData.treesNode.addListenerForSingleValueEvent(object : ValueEventListener {

            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val treeSnapshot = dataSnapshot.getValue(Tree::class.java)
                //...
            }


            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
            }
        })


//        val tree1 = Tree(
//                name = "tree1",
//                description = "cool tree",
//                treeLat = 1.1,
//                treeLong = 1.1
//        )
//        val tree2 = Tree(
//                name = "tree2",
//                description = "cool tree",
//                treeLat = 2.1,
//                treeLong = 2.1
//        )
//        val tree3 = Tree(
//                name = "tree3",
//                description = "cool tree",
//                treeLat = 3.1,
//                treeLong = 3.1
//        )
//        AppData.SharedInstance.treesArray.add(tree1)
//        AppData.SharedInstance.treesArray.add(tree2)
//        AppData.SharedInstance.treesArray.add(tree3)
    }

}