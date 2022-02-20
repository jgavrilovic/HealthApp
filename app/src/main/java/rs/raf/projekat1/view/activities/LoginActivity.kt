package rs.raf.projekat1.view.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_login.*
import rs.raf.projekat1.R


class LoginActivity : AppCompatActivity(R.layout.activity_login) {
    companion object {
        const val SHARED_PREF = "Login_shared_pref"
        const val IME = "Ime"
        const val PREZIME = "Prezime"
        const val BOLNICA = "Bolnica"
        const val PIN = "Pin"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val sharedPref = getSharedPreferences(SHARED_PREF, Context.MODE_PRIVATE)
        val editor = sharedPref.edit()

        txtPin.visibility = View.INVISIBLE
        btPIN.setOnClickListener { txtPin.visibility = View.VISIBLE }

        btPrijava.setOnClickListener {
            when {
                txtIme.text.trim().isEmpty() -> {
                    Toast.makeText(this@LoginActivity, "Polje ime ne sme biti prazno", Toast.LENGTH_SHORT).show()
                }
                txtPrezime.text.trim().isEmpty() -> {
                    Toast.makeText(this@LoginActivity, "Polje prezime ne sme biti prazno", Toast.LENGTH_SHORT).show()
                }
                txtBolnica.text.trim().isEmpty() -> {
                    Toast.makeText(this@LoginActivity, "Polje bolnica ne sme biti prazno", Toast.LENGTH_SHORT).show()
                }
                txtPin.text.trim().isEmpty() -> {
                    Toast.makeText(this@LoginActivity, "Polje pin ne sme biti prazno", Toast.LENGTH_SHORT).show()
                }
                txtPin.text.trim().length!=4 -> {
                    Toast.makeText(this@LoginActivity, "Pin nije odgovarajuce duzine", Toast.LENGTH_SHORT).show()
                }
                txtPin.text.toString().toInt()!=1234 -> {
                    Toast.makeText(this@LoginActivity, "Pin nije ispravan", Toast.LENGTH_SHORT).show()
                }
                else -> {
                    editor.putString(IME, txtIme.text.toString())
                    editor.putString(PREZIME, txtPrezime.text.toString())
                    editor.putString(BOLNICA, txtBolnica.text.toString())
                    editor.putInt(PIN, txtPin.text.toString().toInt())
                    editor.apply()
                    Toast.makeText(this@LoginActivity, "Login uspesan", Toast.LENGTH_SHORT).show()

                    val intent = Intent(this,MainActivity::class.java)
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent)
                }
            }
        }
    }
}
