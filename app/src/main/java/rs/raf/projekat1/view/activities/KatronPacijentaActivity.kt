package rs.raf.projekat1.view.activities

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.activity_karton_pacijent.*
import rs.raf.projekat1.R
import rs.raf.projekat1.model.Pacijent
import rs.raf.projekat1.view.fragments.tabFragmets.HospFragment
import rs.raf.projekat1.view.recycler.adapter.PacijentHospAdapter
import rs.raf.projekat1.viewModel.PacijentViewModel

class KatronPacijentaActivity : AppCompatActivity(R.layout.activity_karton_pacijent) {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val pacijent = intent?.getParcelableExtra<Pacijent>("pacijent")
        if (pacijent != null) {
            TvIme.setText(pacijent.ime)
            TvPrezime.setText(pacijent.prezime)
            TvStanje.setText(pacijent.simptomi)
            tvStanje2.setText(pacijent.simptomi)
            tvDatum.text = pacijent.date
        }else{
            println("Doslo je do greske pri popunjavanju")
        }

        init()
    }

    private fun init(){
        initListener()
    }




    private fun initListener(){
        btOdustani.setOnClickListener {
            finish()
        }

        btIzmeni.setOnClickListener {
            val pacijent = intent.getParcelableExtra<Pacijent>("pacijent")
            pacijent.ime="joca"
            pacijent.prezime= "joca"
            pacijent.simptomi="joca"

            startActivityForResult(intent,111)


            finish()
        }
    }
}