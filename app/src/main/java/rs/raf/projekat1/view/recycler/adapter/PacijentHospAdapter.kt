package rs.raf.projekat1.view.recycler.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import rs.raf.projekat1.R
import rs.raf.projekat1.model.Pacijent
import rs.raf.projekat1.view.recycler.diff.PacijentHospDiffItemCallback
import rs.raf.projekat1.view.recycler.viewHolder.PacijentHospViewHolder


class PacijentHospAdapter(pacijentHospDiffItemCallback: PacijentHospDiffItemCallback, val onKartonPacijentClick: (Pacijent)-> Unit, val onOtpustPacijentClick: (Pacijent)-> Unit) : ListAdapter<Pacijent, PacijentHospViewHolder>(pacijentHospDiffItemCallback) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType:Int):PacijentHospViewHolder{
        val layoutInflater = LayoutInflater.from(parent.context)
        val containerView = layoutInflater.inflate(R.layout.layout_hosp_list_item,parent,false)
        return PacijentHospViewHolder(containerView,
            {
                val pacijent = getItem(it)
                onKartonPacijentClick(pacijent)
            },
            {
                val pacijent = getItem(it)
                onOtpustPacijentClick(pacijent)
            }
        )
    }

    override fun onBindViewHolder(holderCekaonica: PacijentHospViewHolder, position:Int){
        val pacijent = getItem(position)
        holderCekaonica.bind(pacijent)
    }



}
