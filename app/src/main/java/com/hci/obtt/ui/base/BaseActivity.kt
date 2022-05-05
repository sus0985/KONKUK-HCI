package com.hci.obtt.ui.base

import android.os.Bundle
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class BaseActivity<T : ViewDataBinding>(@LayoutRes private val layoutId: Int) :
    AppCompatActivity() {

    private var _binding: T? = null
    protected val binding: T
        get() = checkNotNull(_binding)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = DataBindingUtil.setContentView<T>(this, layoutId).also {
            it.lifecycleOwner = this
        }
    }

    override fun onDestroy() {
        _binding?.run {
            lifecycleOwner = null
            unbind()
        }

        super.onDestroy()
    }

    fun showToast(id: Int) {
        Toast.makeText(this, getString(id), Toast.LENGTH_SHORT).show()
    }
}
