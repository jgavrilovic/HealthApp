package rs.raf.projekat1.view.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.fragment_stanje.*
import rs.raf.projekat1.R
import rs.raf.projekat1.viewModel.PacijentViewModel


class StanjeFragment : Fragment(R.layout.fragment_stanje) {

    private val pacijentViewModel: PacijentViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initObservers()
    }



    private fun initObservers(){
        pacijentViewModel.getListCekaonicaLista().observe(viewLifecycleOwner, Observer {
            textBrCekaonica.text = it.size.toString()
        })
        pacijentViewModel.getListHospLista().observe(viewLifecycleOwner, Observer {
            textbrPrimljenih.text = it.size.toString()

        })
        pacijentViewModel.getListOtpLista().observe(viewLifecycleOwner, Observer {
            textBrOtpustenih.text = it.size.toString()
        })
    }





}
