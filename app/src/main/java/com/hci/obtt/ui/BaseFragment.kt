package com.hci.obtt.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

abstract class BaseFragment<T : ViewDataBinding>(@LayoutRes private val layoutId: Int) :
    Fragment() {

    private var _binding: T? = null
    protected val binding: T
        get() = checkNotNull(_binding)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return DataBindingUtil.inflate<T>(inflater, layoutId, container, false).also {
            it.lifecycleOwner = viewLifecycleOwner
            _binding = it
        }?.root
    }

    override fun onDestroyView() {
        _binding?.run {
            lifecycleOwner = null
            unbind()
        }

        super.onDestroyView()

        _binding = null
    }
}
