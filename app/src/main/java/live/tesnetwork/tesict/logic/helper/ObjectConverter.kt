package live.tesnetwork.tesict.logic.helper

import java.text.SimpleDateFormat
import java.util.Date

fun Date.toNormalDateString() : String {
    val sdf = SimpleDateFormat("dd/MM/yyyy")
    return sdf.format(this)
}

fun Date.toSystemDateString() : String {
    val sdf = SimpleDateFormat("yyyy-MM-dd")
    return sdf.format(this)
}