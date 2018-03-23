package com.markoss.treeclimbrandroid

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ListView
import android.widget.TextView
import com.markoss.treeclimbrandroid.*

val names = arrayListOf<String>(
        "Donald Trump", "Steve Jobs", "Tim Cook"
)

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
            val selectedItem = trees[position]
            val intent = Intent(this, DetailActivity::class.java)
            startActivity(intent)
        }
    }
}

class MyCustomAdapter(context: Context) : BaseAdapter() {

    val mContext: Context

//    val names = arrayListOf<String>(
//            "Donald Trump", "Steve Jobs", "Tim Cook"
//    )

    init {
        mContext = context
    }

    // number of rows in list
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

        val nameTextView = rowMain.findViewById<TextView>(R.id.name_textview)
        nameTextView.text = trees[position].treeName

        val positionTextView = rowMain.findViewById<TextView>(R.id.position_textview)
        positionTextView.text = trees[position].treeDescription

        return rowMain


//            val textView = TextView(mContext)
//            textView.text = "HERE is my ROW for my LISTVIEW"
    }
}


