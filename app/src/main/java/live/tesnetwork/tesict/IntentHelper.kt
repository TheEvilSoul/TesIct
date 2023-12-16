package live.tesnetwork.tesict

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.core.content.ContextCompat.startActivity
import live.tesnetwork.tesict.activity.AppointmentsActivity
import live.tesnetwork.tesict.activity.DevicesActivity
import live.tesnetwork.tesict.activity.HomeActivity
import live.tesnetwork.tesict.activity.InvoicesActivity
import live.tesnetwork.tesict.activity.WorkOrdersActivity

interface IntentHelper {
    fun getContext(): Context
    fun getBundle(): Bundle?

    fun getHomeIntent(): Intent {
        return Intent(getContext(), HomeActivity::class.java)
    }
    fun gotoHome() {
        startIntent(getHomeIntent())
    }

    fun getDeviceIntent(): Intent {
        return Intent(getContext(), DevicesActivity::class.java)
    }

    fun gotoDevices() {
        startIntent(getDeviceIntent())
    }

    fun getAppointmentsIntent(): Intent {
        return Intent(getContext(), AppointmentsActivity::class.java)
    }

    fun gotoAppointments() {
        startIntent(getAppointmentsIntent())
    }

    fun getInvoicesIntent(): Intent {
        return Intent(getContext(), InvoicesActivity::class.java)
    }

    fun gotoInvoices() {
        startIntent(getInvoicesIntent())
    }

    fun getWorkOrdersIntent(): Intent {
        return Intent(getContext(), WorkOrdersActivity::class.java)
    }

    fun gotoWorkOrders() {
        startIntent(getWorkOrdersIntent())
    }

    fun startIntent(intent: Intent) {
        startActivity(getContext(), intent, getBundle())
    }

}