package com.markoss.treeclimbrandroid

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

/**
 * Created by spinkringle on 2018-04-11.
 */
class DetailPhotoGridViewAdapter : BaseAdapter {

    var con: Context
    private lateinit var inflater: LayoutInflater

    constructor(con: Context) : super() {
        this.con = con
        inflater = con.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    }


    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var holder: Holder
        var rv: View
        rv = inflater.inflate(R.layout.gridview_photocell_layout,null)
        holder.tv = rv.findViewById(R.id.photoCellTextView) as TextView
        holder.iv = rv.findViewById(R.id.photoCellTextView) as ImageView

    }

    override fun getItem(position: Int): Any? {
        return null
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return 10

    }
    public class Holder {

        lateinit var tv: TextView
        lateinit var iv: ImageView
        }

}