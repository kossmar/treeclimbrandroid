package com.markoss.treeclimbrandroid

/**
 * Created by spinkringle on 2018-03-25.
 */

import android.support.v4.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class DetailMoreTab: Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_detail_more_tab, container, false)

    }
}