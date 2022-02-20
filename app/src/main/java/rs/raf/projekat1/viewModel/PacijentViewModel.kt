package rs.raf.projekat1.viewModel

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import rs.raf.projekat1.model.Pacijent
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.util.*

class PacijentViewModel : ViewModel() {

    private val pacijentCekaonica : MutableLiveData<List<Pacijent>> = MutableLiveData()
    private val pacijentiHosp : MutableLiveData<List<Pacijent>> = MutableLiveData()
    private val pacijentiOtpusten : MutableLiveData<List<Pacijent>> = MutableLiveData()


    private val cekaonicaList :MutableList<Pacijent> = mutableListOf()
    private val hospLista :MutableList<Pacijent> = mutableListOf()
    private val otpusteniList :MutableList<Pacijent> = mutableListOf()

    init {
        val listToSubmit0 = mutableListOf<Pacijent>()
        listToSubmit0.addAll(cekaonicaList)
        pacijentCekaonica.value=listToSubmit0

        val listToSubmit1 = mutableListOf<Pacijent>()
        listToSubmit1.addAll(hospLista)
        pacijentiHosp.value=listToSubmit1

        val listToSubmit2 = mutableListOf<Pacijent>()
        listToSubmit2.addAll(otpusteniList)
        pacijentiOtpusten.value=listToSubmit2
    }


    fun getListCekaonicaLista() : LiveData<List<Pacijent>>{
        return pacijentCekaonica
    }

    fun addPacijentCekaonica(id:UUID, ime:String, prezime:String, simptomi:String){


        val pacijent = Pacijent(id,ime,prezime, simptomi,null, null)

        cekaonicaList.add(pacijent)
        val listToSubmit = mutableListOf<Pacijent>()
        listToSubmit.addAll(cekaonicaList)
        pacijentCekaonica.value = listToSubmit
    }



    fun getListHospLista() : LiveData<List<Pacijent>>{
        return pacijentiHosp
    }
    fun addPacijentHosp(id:UUID, ime:String, prezime:String, simptomi:String){
        val pacijent = Pacijent(id, ime,prezime, simptomi,null, null)

        hospLista.add(pacijent)
        val listToSubmit = mutableListOf<Pacijent>()
        listToSubmit.addAll(hospLista)
        pacijentiHosp.value = listToSubmit
    }



    fun getListOtpLista() : LiveData<List<Pacijent>>{
        return pacijentiOtpusten
    }
    fun addPacijentOtp(id:UUID, ime:String, prezime:String, simptomi:String){
        val pacijent = Pacijent(id, ime,prezime, simptomi,null, null)

        otpusteniList.add(pacijent)
        val listToSubmit = mutableListOf<Pacijent>()
        listToSubmit.addAll(otpusteniList)
        pacijentiOtpusten.value = listToSubmit
    }

    fun remove(pacijent: Pacijent){
        val listToSubmit :List<Pacijent>
        listToSubmit=cekaonicaList
        listToSubmit.remove(pacijent)
        pacijentCekaonica.value=listToSubmit

    }

    @SuppressLint("SimpleDateFormat")
    fun moveHosp(pacijent: Pacijent){
        lateinit var pacijent1 :Pacijent
        val listToSubmit :List<Pacijent>
        val listToSubmit1 :List<Pacijent>
        listToSubmit=(cekaonicaList)
        listToSubmit1=(hospLista)

        for (number in listToSubmit) {
            if(number==pacijent){
                pacijent1=number


                val sdf = SimpleDateFormat("dd/M/yyyy hh:mm:ss")
                val currentDate = sdf.format(Date())
                pacijent1.date= currentDate
                pacijent1=number

            }
        }
        listToSubmit.remove(pacijent)
        pacijentCekaonica.value=listToSubmit
        listToSubmit1.add(pacijent1)
        pacijentiHosp.value=listToSubmit1
    }



    @SuppressLint("SimpleDateFormat")
    fun otpust(pacijent: Pacijent){
        lateinit var pacijent2 :Pacijent
        val listToSubmit :List<Pacijent>
        val listToSubmit1 :List<Pacijent>

        listToSubmit=(hospLista)
        listToSubmit1=(otpusteniList)

        for (number in listToSubmit) {
            if(number==pacijent){
                pacijent2=number
                val sdf = SimpleDateFormat("dd/M/yyyy hh:mm:ss")
                val currentDate = sdf.format(Date())
                pacijent2.date= currentDate

            }
        }

        listToSubmit.remove(pacijent)
        pacijentiHosp.value=listToSubmit
        listToSubmit1.add(pacijent2)
        pacijentiOtpusten.value=listToSubmit1



    }

    fun filter(string: String){
        val filtrirajListu = cekaonicaList.filter {
            it.ime.toLowerCase().startsWith(string.toLowerCase()) || it.prezime.toLowerCase().startsWith(string.toLowerCase())
        }
        pacijentCekaonica.value=filtrirajListu
    }

    fun filter1(string: String){
        val filtrirajListu = hospLista.filter {
            it.ime.toLowerCase().startsWith(string.toLowerCase()) || it.prezime.toLowerCase().startsWith(string.toLowerCase())
        }
        pacijentiHosp.value=filtrirajListu
    }

    fun filter2(string: String){
        val filtrirajListu = otpusteniList.filter {
            it.ime.toLowerCase().startsWith(string.toLowerCase()) || it.prezime.toLowerCase().startsWith(string.toLowerCase())
        }
        pacijentiOtpusten.value=filtrirajListu
    }


}