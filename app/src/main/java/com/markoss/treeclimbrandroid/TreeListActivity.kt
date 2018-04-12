package com.markoss.treeclimbrandroid

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.*
import android.widget.BaseAdapter
import android.widget.ListView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.row_main.view.*

var trees = arrayListOf<Tree>()


class TreeListActivity : AppCompatActivity() {

    private lateinit var listView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_treelist)

        listView = findViewById<ListView>(R.id.main_listview)

        listView.adapter = MyCustomAdapter(this) // custom adapter telling list what to render

        trees = AppData.treesArray

        val context = this

        listView.setOnItemClickListener { _, _, position, _ ->
            val selectedTree = trees[position]
            val intent = Intent(this,DetailActivity::class.java)
            intent.putExtra("tree", selectedTree)
            startActivity(intent)
        }

        trees = AppData.SharedInstance.treesArray
    }


}

class MyCustomAdapter(context: Context) : BaseAdapter() {

    val mContext: Context

    init {
        mContext = context
    }

    override fun getCount(): Int {
        return trees.size
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItem(position: Int): Any {
        return "TEST STRING"
    }

    // renders out each row
    override fun getView(position: Int, countView: View?, viewGroup: ViewGroup?): View {
        val layoutInflater = LayoutInflater.from(mContext)
        val rowMain = layoutInflater.inflate(R.layout.row_main, viewGroup, false)
        val currentTree:Tree = trees[position]
//        Picasso.get().load(currentTree.treePhotoURL).into(rowMain.list_imageView)
        Glide.with(rowMain).load(currentTree.treePhotoURL).into(rowMain.list_imageview)
//        rowMain.list_imageView.setImageResource(trees[position].treePhoto)
        rowMain.name_textview.text = trees[position].treeName

        return rowMain
    }
}


