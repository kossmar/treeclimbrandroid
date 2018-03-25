package com.markoss.treeclimbrandroid

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.bumptech.glide.Glide
import com.markoss.treeclimbrandroid.R
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {


    var tree:Tree = Tree("", "", 0.0, 0.0)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val bundle = intent.extras
        tree = bundle.getParcelable("tree")
        this.title = tree.treeName
        nameTextView.text = tree.treeName
        Glide.with(this).load(tree.treePhotoURL).into(this.imageView)





    }

}
