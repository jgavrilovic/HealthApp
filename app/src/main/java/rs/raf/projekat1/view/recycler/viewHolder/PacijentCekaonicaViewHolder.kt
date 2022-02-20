package rs.raf.projekat1.view.recycler.viewHolder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.layout_cekaonica_list_item.*
import rs.raf.projekat1.model.Pacijent

class PacijentCekaonicaViewHolder(override val containerView: View, onZdravClick: (Int)->Unit, onHospClick: (Int)->Unit) :RecyclerView.ViewHolder(containerView), LayoutContainer{


    init {

        btZdrav.setOnClickListener {
            val position = adapterPosition
            onZdravClick(position)
        }
        btHosp.setOnClickListener {
            val position = adapterPosition
            onHospClick(position)
        }
    }
    fun bind(pacijent: Pacijent){
        imeTv.text=pacijent.ime
        prezimeTv.text=pacijent.prezime
        simptomiTv.text=pacijent.simptomi
    }
}