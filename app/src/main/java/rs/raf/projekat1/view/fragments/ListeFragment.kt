package rs.raf.projekat1.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import kotlinx.android.synthetic.main.fragment_liste.*

import rs.raf.projekat1.R
import rs.raf.projekat1.view.viewPager.TabAdapter


class ListeFragment : Fragment(R.layout.fragment_liste) {



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        println("ON CREATE LISTE")
       init()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        println("ON DESTROY LISTE")
    }

    private fun init() {
        initViewPager()

    }
    private fun initViewPager() {
        tabPager.adapter = TabAdapter(childFragmentManager)
        tabLayour.setupWithViewPager(tabPager)
    }

}
