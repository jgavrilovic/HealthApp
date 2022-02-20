package rs.raf.projekat1.view.viewPager

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import rs.raf.projekat1.view.fragments.StanjeFragment
import rs.raf.projekat1.view.fragments.ProfilFragment
import rs.raf.projekat1.view.fragments.UnosFragment
import rs.raf.projekat1.view.fragments.ListeFragment

class PagerAdapter (fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    companion object {
        private const val ITEM_COUNT = 4
        const val FRAGMENT_1 = 0
        const val FRAGMENT_2 = 1
        const val FRAGMENT_3 = 2
        const val FRAGMENT_4 = 3
    }


    override fun getItem(position: Int): Fragment {
        return when(position){
            FRAGMENT_1 -> StanjeFragment()
            FRAGMENT_2 -> UnosFragment()
            FRAGMENT_3 -> ListeFragment()
            else -> ProfilFragment()
        }
    }

    override fun getCount(): Int {
        return ITEM_COUNT
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position){
            FRAGMENT_1 -> "1"
            FRAGMENT_2 -> "2"
            FRAGMENT_3 -> "3"
            else -> "4"
        }
    }

}