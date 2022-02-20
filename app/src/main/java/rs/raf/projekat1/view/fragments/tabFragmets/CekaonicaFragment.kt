package rs.raf.projekat1.view.fragments.tabFragmets

import android.os.Bundle
import android.view.View
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_cekaonica.*
import kotlinx.android.synthetic.main.layout_cekaonica_list_item.*
import rs.raf.projekat1.R
import rs.raf.projekat1.view.recycler.adapter.PacijentCekaonicaAdapter
import rs.raf.projekat1.view.recycler.diff.PacijentCekaonicaDiffItemCallback
import rs.raf.projekat1.viewModel.PacijentViewModel

class CekaonicaFragment :Fragment(R.layout.fragment_cekaonica){

    private val pacijentViewModel : PacijentViewModel by activityViewModels()

    private lateinit var pacijentCekaonicaAdapter: PacijentCekaonicaAdapter

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
        pacijentViewModel.getListCekaonicaLista().observe(viewLifecycleOwner, Observer {
            pacijentCekaonicaAdapter.submitList(it)
        })
    }


    private fun initListeners(){
        searchView2.doAfterTextChanged {
            pacijentViewModel.filter(it.toString())
        }


    }
    private fun initRecycler(){
        listRvCekao.layoutManager = LinearLayoutManager(this.context)
        pacijentCekaonicaAdapter= PacijentCekaonicaAdapter(
            PacijentCekaonicaDiffItemCallback(),
            {
                pacijentViewModel.remove(it)
            },
            {
                pacijentViewModel.moveHosp(it)
            }
        )
        listRvCekao.adapter = pacijentCekaonicaAdapter
    }



}