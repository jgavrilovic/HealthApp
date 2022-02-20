package rs.raf.projekat1.view.recycler.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import rs.raf.projekat1.R
import rs.raf.projekat1.model.Pacijent
import rs.raf.projekat1.view.recycler.diff.PacijentCekaonicaDiffItemCallback
import rs.raf.projekat1.view.recycler.viewHolder.PacijentCekaonicaViewHolder


class PacijentCekaonicaAdapter(pacijentCekaonicaDiffItemCallback: PacijentCekaonicaDiffItemCallback, val onZdravPacijentClick: (Pacijent)-> Unit, val onHospPacijentClick: (Pacijent)-> Unit) : ListAdapter<Pacijent, PacijentCekaonicaViewHolder>(pacijentCekaonicaDiffItemCallback) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType:Int):PacijentCekaonicaViewHolder{
        val layoutInflater = LayoutInflater.from(parent.context)
        val containerView = layoutInflater.inflate(R.layout.layout_cekaonica_list_item,parent,false)
        val viewHolder = PacijentCekaonicaViewHolder(
            containerView,
            {
                val pacijent = getItem(it)
                onZdravPacijentClick(pacijent)
            },
            {
                val pacijent = getItem(it)
                onHospPacijentClick(pacijent)
            }
        )
        return viewHolder
    }

    override fun onBindViewHolder(holderCekaonica: PacijentCekaonicaViewHolder, position:Int){
        val pacijent = getItem(position)
        holderCekaonica.bind(pacijent)
    }



}
