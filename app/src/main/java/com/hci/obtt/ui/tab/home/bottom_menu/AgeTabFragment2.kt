package com.hci.obtt.ui.tab.home.bottom_menu

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hci.obtt.R

class AgeTabFragment2 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        newInstant()
        return inflater.inflate(R.layout.fragment_age_tab2, container, false)
    }

    public fun newInstant() : AgeTabFragment2 {
        val args = Bundle()
        val frag = AgeTabFragment2()
        frag.arguments = args
        return frag
    }

}