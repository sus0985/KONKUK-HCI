package com.hci.obtt.ui.tab.home.bottom_menu

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class AgeFragmentAdapter (fm : FragmentManager) : FragmentPagerAdapter(fm) {
    override fun getCount(): Int = 3

    override fun getItem(position: Int): Fragment {
        val fragment = when(position) {
            0->AgeTabFragment1().newInstant()
            1->AgeTabFragment2().newInstant()
            2->AgeTabFragment3().newInstant()
            else->AgeTabFragment1().newInstant()
        }

        return fragment
    }

    override fun getPageTitle(position: Int): CharSequence? {
        val title = when(position) {
            0->"10대 - 20대"
            1->"30대 - 40대"
            2->"50대 - 60대"
            else->"10대 - 20대"
        }
        return title
    }
}