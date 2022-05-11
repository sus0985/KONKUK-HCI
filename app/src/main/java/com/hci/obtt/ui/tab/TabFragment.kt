package com.hci.obtt.ui.tab

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.annotation.IntDef
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.tabs.TabLayoutMediator
import com.hci.obtt.R
import com.hci.obtt.databinding.FragmentTabBinding
import com.hci.obtt.ui.base.BaseFragment
import com.hci.obtt.ui.tab.community.CommunityFragment
import com.hci.obtt.ui.tab.home.HomeFragment
import com.hci.obtt.ui.tab.timeline.TimelineFragment

class TabFragment : BaseFragment<FragmentTabBinding>(R.layout.fragment_tab) {

    private val titles by lazy {
        arrayOf(
            getString(R.string.kr_home),
            getString(R.string.timeline),
            getString(R.string.community)
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(TAG, "onViewCreated() called with: view = [$view], savedInstanceState = [$savedInstanceState]")

        binding.viewPager.adapter = ViewPagerAdapter(requireActivity(), titles)

        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = titles[position]
        }.attach()
    }


    private class ViewPagerAdapter(
        activity: FragmentActivity,
        private val titles: Array<String>
    ) : FragmentStateAdapter(activity) {

        override fun getItemCount(): Int = titles.size


        override fun createFragment(@HomeTab position: Int): Fragment {
            val fragment: Fragment = when (position) {
                TAB_HOME -> HomeFragment.newInstance()
                TAB_TIMELINE -> TimelineFragment.newInstance()
                TAB_COMMUNITY -> CommunityFragment.newInstance()
                else -> throw IllegalStateException("Unknown tab")
            }

            return fragment
        }

        companion object {
            const val TAB_HOME = 0
            const val TAB_TIMELINE = 1
            const val TAB_COMMUNITY = 2

            @IntDef(TAB_HOME, TAB_TIMELINE, TAB_COMMUNITY)
            @Retention(AnnotationRetention.SOURCE)
            annotation class HomeTab
        }
    }


    companion object {

        private const val TAG = "TabFragment"
    }
}