package com.markoss.treeclimbrandroid

/**
 * Created by spinkringle on 2018-03-25.
 */

import android.content.Context
import android.support.v4.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridView

class DetailPhotoTab: Fragment() {

    var con: Context = this.context.applicationContext
    var photoArray = ArrayList<Photo>()
    lateinit var gridView: GridView
    lateinit var cl: DetailPhotoGridViewAdapter



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        gridView = container!!.findViewById<GridView>(R.id.gridView) as GridView
        cl = DetailPhotoGridViewAdapter(con)

        return inflater.inflate(R.layout.fragment_detail_photo_tab, container, false)
    }
}