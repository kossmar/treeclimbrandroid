package com.markoss.treeclimbrandroid

import java.net.URL
import java.time.LocalDateTime

/**
 * Created by spinkringle on 2018-03-21.
 */
class Tree {

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
    var treeCreator: String = ""
    var treeCreatorName: String = ""
    //    var treeComments = Array<Comment>()
    var distFromUser = Double
    var isHidden: Boolean = false
//    var treeID: String = name + "|" + LocalDateTime.now() + "1"

    constructor()

    constructor(name: String, description: String, treeLat: Double, treeLong: Double) {
        this.treeName = name
        this.treeDescription = description
        this.treeLatitude = treeLat
        this.treeLongitude = treeLong


    }
}