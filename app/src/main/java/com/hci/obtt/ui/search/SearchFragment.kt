package com.hci.obtt.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.hci.obtt.R
import com.hci.obtt.databinding.FragmentSearchBinding
import com.hci.obtt.ui.base.BaseFragment

class SearchFragment : BaseFragment<FragmentSearchBinding>(R.layout.fragment_search) {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_search_result, container, false)
        val btn: Button = view.findViewById(R.id.filter_btn)

        //nav 연결

        return view
    }
}
