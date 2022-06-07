package com.hci.obtt.ui.bookmark

import android.os.Bundle
import android.view.View
import com.hci.obtt.R
import com.hci.obtt.databinding.FragmentBookmarkBinding
import com.hci.obtt.model.DummyDataPool
import com.hci.obtt.ui.base.BaseFragment

class BookmarkFragment : BaseFragment<FragmentBookmarkBinding>(R.layout.fragment_bookmark) {

    private val adapter = BookmarkAdapter(DummyDataPool.videos)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recycler.adapter = adapter
    }

}