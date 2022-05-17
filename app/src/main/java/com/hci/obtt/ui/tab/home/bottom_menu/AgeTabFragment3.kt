package com.hci.obtt.ui.tab.home.bottom_menu

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hci.obtt.R

class AgeTabFragment3 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        newInstant()
        return inflater.inflate(R.layout.fragment_age_tab3, container, false)
    }

    public fun newInstant() : AgeTabFragment3 {
        val args = Bundle()
        val frag = AgeTabFragment3()
        frag.arguments = args
        return frag
    }

}