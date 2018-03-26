package com.markoss.treeclimbrandroid

/**
 * Created by spinkringle on 2018-03-25.
 */

import android.support.v4.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class DetailPhotoTab: Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_detail_photo_tab, container, false)

    }
}