package rs.raf.projekat1.view.recycler.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import rs.raf.projekat1.R
import rs.raf.projekat1.model.Pacijent
import rs.raf.projekat1.view.recycler.diff.PacijentOtpusteniDiffItemCallback
import rs.raf.projekat1.view.recycler.viewHolder.PacijentCekaonicaViewHolder
import rs.raf.projekat1.view.recycler.viewHolder.PacijentOtpusteniViewHolder


class PacijentOtpusteniAdapter(pacijentOtpusteniDiffItemCallback: PacijentOtpusteniDiffItemCallback ) : ListAdapter<Pacijent, PacijentOtpusteniViewHolder>(pacijentOtpusteniDiffItemCallback) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType:Int):PacijentOtpusteniViewHolder{
        val layoutInflater = LayoutInflater.from(parent.context)
        val containerView = layoutInflater.inflate(R.layout.layout_otpusteni_list_item,parent,false)
        return PacijentOtpusteniViewHolder(containerView)
    }

    override fun onBindViewHolder(holderCekaonica: PacijentOtpusteniViewHolder, position:Int){
        val pacijent = getItem(position)
        holderCekaonica.bind(pacijent)
    }



}
