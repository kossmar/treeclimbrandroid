package com.markoss.treeclimbrandroid

import android.app.ActionBar
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.bumptech.glide.Glide

/**
 * Created by spinkringle on 2018-04-11.
 */
class DetailPhotoGridViewAdapter : BaseAdapter {

    var con: Context
    var photoArray = ArrayList<Photo>()
    private var inflater: LayoutInflater

    constructor(con: Context, photoArray: ArrayList<Photo>) : super() {
        this.con = con
        this.photoArray = photoArray
        inflater = con.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    }


    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        var holder = Holder()
        var rv: View
        var cellWidth: Int = 40
        var cellHeight: Int = 40

            rv = inflater.inflate(R.layout.gridview_photocell_layout, null)
//            rv.layoutParams.width = cellWidth
//            rv.layoutParams.height = cellWidth
            holder.tv = rv.findViewById<TextView>(R.id.photoCellTextView) as TextView
            holder.iv = rv.findViewById<ImageView>(R.id.photoCellImageView) as ImageView
            if (photoArray != null) {
                var currentPhoto = photoArray[position]
                Glide.with(rv).load(currentPhoto.photoURL).into(holder.iv)
            }
        return rv
    }

    override fun getItem(position: Int): Any? {
        return null
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getCount(): Int {
            return photoArray.size
    }
    class Holder {

        lateinit var tv: TextView
        lateinit var iv: ImageView
        }

}