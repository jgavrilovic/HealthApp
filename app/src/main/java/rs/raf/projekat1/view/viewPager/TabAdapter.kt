package rs.raf.projekat1.view.viewPager

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import rs.raf.projekat1.view.fragments.StanjeFragment
import rs.raf.projekat1.view.fragments.ProfilFragment
import rs.raf.projekat1.view.fragments.UnosFragment
import rs.raf.projekat1.view.fragments.ListeFragment
import rs.raf.projekat1.view.fragments.tabFragmets.CekaonicaFragment
import rs.raf.projekat1.view.fragments.tabFragmets.HospFragment
import rs.raf.projekat1.view.fragments.tabFragmets.OtpusteniFragment

class TabAdapter (fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    companion object {
        private const val ITEM_COUNT = 3
        const val TAB_1 = 0
        const val TAB_2 = 1
        const val TAB_3 = 2
    }


    override fun getItem(position: Int): Fragment {
        return when(position){
            TAB_1 -> CekaonicaFragment()
            TAB_2 -> HospFragment()
            else -> OtpusteniFragment()
        }
    }

    override fun getCount(): Int {
        return ITEM_COUNT
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position){
            TAB_1 -> "Cekaonica"
            TAB_2 -> "Hospitalizovani"
            else -> "Otpusteni"
        }
    }

}