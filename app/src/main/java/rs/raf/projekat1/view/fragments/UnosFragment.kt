package rs.raf.projekat1.view.fragments


import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import kotlinx.android.synthetic.main.fragment_unos.*
import rs.raf.projekat1.R
import rs.raf.projekat1.viewModel.PacijentViewModel
import java.util.*


class UnosFragment : Fragment(R.layout.fragment_unos) {


    private val pacijentViewModel: PacijentViewModel by activityViewModels()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var i=0
        val uuid: UUID = UUID.randomUUID()
        btDodaj.setOnClickListener {
            when {
                txtIme.text.trim().isEmpty() -> {
                    Toast.makeText(this.requireContext(), "Polje ime ne sme biti prazno", Toast.LENGTH_SHORT).show()

                }
                txtPrezime.text.trim().isEmpty() -> {
                    Toast.makeText(
                        this.requireContext(),"Polje prezime ne sme biti prazno", Toast.LENGTH_SHORT).show()
                }
                txtStanje.text.trim().isEmpty() -> {
                    Toast.makeText(this.requireContext(), "Polje stanje ne sme biti prazno", Toast.LENGTH_SHORT).show()
                }
                else -> {
                    pacijentViewModel.addPacijentCekaonica(uuid, txtIme.text.toString(), txtPrezime.text.toString(), txtStanje.text.toString())
                    //pacijentViewModel.addPacijentHosp(uuid, txtIme.text.toString(), txtPrezime.text.toString(), txtStanje.text.toString())
                    //pacijentViewModel.addPacijentOtp(uuid, txtIme.text.toString(), txtPrezime.text.toString(), txtStanje.text.toString())


                    println("------------------" + getCurrentDateTime())

                    txtIme.text.clear()
                    txtPrezime.text.clear()
                    txtStanje.text.clear()
                    Toast.makeText(this.requireContext(), "Uspesano dodat!", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }



    fun getCurrentDateTime(): Date {
        return Calendar.getInstance().time
    }
}
