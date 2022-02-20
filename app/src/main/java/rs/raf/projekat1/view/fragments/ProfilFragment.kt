package rs.raf.projekat1.view.fragments



import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_profil.*
import rs.raf.projekat1.R
import rs.raf.projekat1.view.activities.LoginActivity
import rs.raf.projekat1.view.activities.ProfilIzmeniActivity


class ProfilFragment : Fragment(R.layout.fragment_profil) {



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()


    }
    fun init(){
        initListener()
        izmena()
    }

    private fun initListener(){
        btIzmeni.setOnClickListener {
            val intent = Intent(activity,ProfilIzmeniActivity::class.java)
            startActivity(intent)
        }

        btOdjava.setOnClickListener {
            val preferences = this.requireActivity().getSharedPreferences(LoginActivity.SHARED_PREF, Context.MODE_PRIVATE)
            val editor = preferences.edit()
           /* editor.putString(LoginActivity.IME, null)
            editor.putString(LoginActivity.PREZIME, null)
            editor.putString(LoginActivity.BOLNICA, null)
            editor.apply()*/
            editor.clear().apply()
            val intent = Intent(activity,LoginActivity::class.java)
            startActivity(intent)
            Toast.makeText(this.requireContext(), "Odjava uspesna", Toast.LENGTH_SHORT).show()
        }
    }

    private fun izmena(){
        val preferences = this.requireActivity().getSharedPreferences(LoginActivity.SHARED_PREF, Context.MODE_PRIVATE)


        txtIme.setText(preferences.getString(LoginActivity.IME,null))
        txtPrezime.setText(preferences.getString(LoginActivity.PREZIME,null))
        txtBolnica.setText(preferences.getString(LoginActivity.BOLNICA,null))



    }

    override fun onResume() {
        super.onResume()
        izmena()
    }

}
