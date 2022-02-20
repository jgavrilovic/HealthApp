package rs.raf.projekat1.view.recycler.viewHolder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.layout_cekaonica_list_item.*
import kotlinx.android.synthetic.main.layout_cekaonica_list_item.imeTv
import kotlinx.android.synthetic.main.layout_cekaonica_list_item.prezimeTv
import kotlinx.android.synthetic.main.layout_hosp_list_item.*
import rs.raf.projekat1.model.Pacijent

class PacijentHospViewHolder(override val containerView: View,onKartonClick: (Int)->Unit, onOtpustClick: (Int)->Unit) :RecyclerView.ViewHolder(containerView), LayoutContainer{


    init {

        btKarton.setOnClickListener {
            val position = adapterPosition
            onKartonClick(position)
        }
        btOtpust.setOnClickListener {
            val position = adapterPosition
            onOtpustClick(position)
        }
    }

    fun bind(pacijent: Pacijent){
        imeTv.text=pacijent.ime
        prezimeTv.text=pacijent.prezime

        Picasso.get().load(pacijent.img).into(imageViewHosp)


    }
}