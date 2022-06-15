package com.hci.obtt.ui.search

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.hci.obtt.R
import com.hci.obtt.databinding.FragmentSearchBinding
import com.hci.obtt.ui.base.BaseFragment

class SearchFragment : BaseFragment<FragmentSearchBinding>(R.layout.fragment_search) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            filterBtn.setOnClickListener {
                findNavController().navigate(R.id.action_searchFragment_to_searchResultFragment)
            }
        }
    }
}
