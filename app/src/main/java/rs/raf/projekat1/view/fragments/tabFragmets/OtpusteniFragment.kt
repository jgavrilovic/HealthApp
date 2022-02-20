package rs.raf.projekat1.view.fragments.tabFragmets

import android.os.Bundle
import android.view.View
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_cekaonica.*
import kotlinx.android.synthetic.main.fragment_otpusteni.*
import rs.raf.projekat1.R
import rs.raf.projekat1.view.recycler.adapter.PacijentCekaonicaAdapter
import rs.raf.projekat1.view.recycler.adapter.PacijentOtpusteniAdapter
import rs.raf.projekat1.view.recycler.diff.PacijentCekaonicaDiffItemCallback
import rs.raf.projekat1.view.recycler.diff.PacijentOtpusteniDiffItemCallback
import rs.raf.projekat1.viewModel.PacijentViewModel

class OtpusteniFragment : Fragment(R.layout.fragment_otpusteni){
    private val pacijentViewModel : PacijentViewModel by activityViewModels()

    private lateinit var pacijentOtpusteniAdapter: PacijentOtpusteniAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        println("ON CREATE LISTE")
        init()
    }


    private fun init(){
        initUI()
        initObservers()
    }
    private fun initUI(){
        initListeners()
        initRecycler()
    }

    private fun initObservers(){
        pacijentViewModel.getListOtpLista().observe(viewLifecycleOwner, Observer {
            pacijentOtpusteniAdapter.submitList(it)
        })
    }


    private fun initListeners(){
        searchView3.doAfterTextChanged {
            pacijentViewModel.filter2(it.toString())
        }
    }

    private fun initRecycler(){
        listRvOtp.layoutManager = LinearLayoutManager(this.context)
        pacijentOtpusteniAdapter= PacijentOtpusteniAdapter(PacijentOtpusteniDiffItemCallback())
        listRvOtp.adapter = pacijentOtpusteniAdapter
    }
}