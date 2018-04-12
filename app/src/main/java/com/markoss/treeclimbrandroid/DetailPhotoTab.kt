package com.markoss.treeclimbrandroid

/**
 * Created by spinkringle on 2018-03-25.
 */

import android.app.Activity
import android.content.Context
import android.support.v4.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridView
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_detail.view.*

class DetailPhotoTab: Fragment() {

    var con: Context = Activity()
    var photoArray = ArrayList<Photo>()
    lateinit var gridView: GridView
    lateinit var cl: DetailPhotoGridViewAdapter

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        con = context!!
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val detailPhotoFragment = inflater.inflate(R.layout.fragment_detail_photo_tab, container, false)
        cl = DetailPhotoGridViewAdapter(con)
        gridView= detailPhotoFragment.findViewById<GridView>(R.id.gridView1) as GridView
        gridView.adapter = cl


        return detailPhotoFragment
    }


}