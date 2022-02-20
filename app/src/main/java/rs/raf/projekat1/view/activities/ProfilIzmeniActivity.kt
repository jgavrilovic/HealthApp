package rs.raf.projekat1.view.activities

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_progil_izmeni.*
import rs.raf.projekat1.R

class ProfilIzmeniActivity : AppCompatActivity(R.layout.activity_progil_izmeni) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_progil_izmeni)
        init()

    }
    fun init(){
        initListener()
    }
    fun initListener(){
        btOdustani.setOnClickListener {
            finish()
        }

        btIzmeni.setOnClickListener {


            when {
                edit1.text.trim().isEmpty() -> {
                    Toast.makeText(
                        this,
                        "Polje ime ne sme biti prazno",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                edit2.text.trim().isEmpty() -> {
                    Toast.makeText(
                        this,
                        "Polje prezime ne sme biti prazno",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                edit3.text.trim().isEmpty() -> {
                    Toast.makeText(
                        this,
                        "Polje bolnica ne sme biti prazno",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                else -> {
                    val preferences = this.getSharedPreferences(LoginActivity.SHARED_PREF, Context.MODE_PRIVATE)
                    val editor = preferences.edit()
                    editor.putString(LoginActivity.IME, edit1.text.toString())
                    editor.putString(LoginActivity.PREZIME, edit2.text.toString())
                    editor.putString(LoginActivity.BOLNICA, edit3.text.toString())
                    editor.apply()
                    finish()
                    Toast.makeText(this, "Unos uspesan", Toast.LENGTH_SHORT).show()
                }
            }


        }
    }
}
