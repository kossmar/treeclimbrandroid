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

    companion object {

        fun newInstance(tree: Tree): DetailPhotoTab {
         val args = Bundle()
            args.putParcelable("tree", tree)
            val photoFragment = DetailPhotoTab()
            photoFragment.arguments = args
            return photoFragment
        }
    }

    var con: Context? = Activity()
    var photoArray = ArrayList<Photo>()
    lateinit var tree: Tree
    var fragmentListener: FragmentListener? = null
    lateinit var gridView: GridView
    lateinit var cl: DetailPhotoGridViewAdapter

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context != null) {
            con = context
        } else null
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val detailPhotoFragment = inflater.inflate(R.layout.fragment_detail_photo_tab, container, false)
        if (con != null) {
            cl = DetailPhotoGridViewAdapter(con as Context, photoArray)
        }
        gridView= detailPhotoFragment.findViewById<GridView>(R.id.gridView1) as GridView

        val args = arguments
        if (args != null) {
            tree = args.getParcelable("tree")
        }

        println(tree.treeName)


        PhotoManager.loadPhotos(tree, {
            photoArray = it
            println(tree.treeName)
            println(photoArray.count())
            cl = DetailPhotoGridViewAdapter(con as Context, photoArray)
//            cl.notifyDataSetChanged()
            gridView.adapter = cl
//            this.gridView.invalidateViews()
        })


        gridView.adapter = cl



        return detailPhotoFragment
    }


}