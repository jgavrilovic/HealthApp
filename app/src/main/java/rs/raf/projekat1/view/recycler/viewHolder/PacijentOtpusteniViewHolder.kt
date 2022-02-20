package rs.raf.projekat1.view.recycler.viewHolder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.layout_cekaonica_list_item.*
import kotlinx.android.synthetic.main.layout_cekaonica_list_item.imeTv
import kotlinx.android.synthetic.main.layout_cekaonica_list_item.prezimeTv
import kotlinx.android.synthetic.main.layout_otpusteni_list_item.*
import rs.raf.projekat1.model.Pacijent
import java.util.*

class PacijentOtpusteniViewHolder(override val containerView: View) :RecyclerView.ViewHolder(containerView), LayoutContainer{

    fun bind(pacijent: Pacijent){
        imeTv.text=pacijent.ime
        prezimeTv.text=pacijent.prezime
        lbOtpusten.text=pacijent.date



    }
}