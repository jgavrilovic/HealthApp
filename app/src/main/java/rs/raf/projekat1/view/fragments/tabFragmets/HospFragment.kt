package rs.raf.projekat1.view.fragments.tabFragmets

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_cekaonica.*
import kotlinx.android.synthetic.main.fragment_hosp.*
import kotlinx.android.synthetic.main.layout_hosp_list_item.*
import rs.raf.projekat1.R
import rs.raf.projekat1.view.activities.KatronPacijentaActivity
import rs.raf.projekat1.view.recycler.adapter.PacijentHospAdapter
import rs.raf.projekat1.view.recycler.diff.PacijentHospDiffItemCallback
import rs.raf.projekat1.viewModel.PacijentViewModel

class HospFragment : Fragment(R.layout.fragment_hosp){
    private val pacijentViewModel : PacijentViewModel by activityViewModels()

    private lateinit var pacijentHospAdapter: PacijentHospAdapter

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
        pacijentViewModel.getListHospLista().observe(viewLifecycleOwner, Observer {
            pacijentHospAdapter.submitList(it)
        })
    }


    private fun initListeners(){
        val intent = Intent(activity, KatronPacijentaActivity::class.java)
        val pacijent =onActivityResult(111,222,intent.getParcelableExtra("pacijent1"))
        println("adasdadasd")
        println(pacijent)


        searchView1.doAfterTextChanged {
            pacijentViewModel.filter1(it.toString())
        }

    }
    private fun initRecycler(){
        listRvHosp.layoutManager = LinearLayoutManager(this.context)
        pacijentHospAdapter= PacijentHospAdapter(
            PacijentHospDiffItemCallback(),
            {
                val intent = Intent(activity, KatronPacijentaActivity::class.java)

                intent.putExtra("pacijent",it)
                startActivity(intent)
            },
            {
                pacijentViewModel.otpust(it)
            }
        )
        listRvHosp.adapter = pacijentHospAdapter
    }
}