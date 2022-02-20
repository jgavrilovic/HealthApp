package rs.raf.projekat1.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.time.LocalDateTime
import java.util.*
@Parcelize
data class Pacijent(
    var id: UUID,
    var ime:String,
    var prezime:String,
    var simptomi:String,
    var img:String?,
    var date:String?


): Parcelable


