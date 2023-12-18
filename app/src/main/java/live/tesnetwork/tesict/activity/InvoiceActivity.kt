package live.tesnetwork.tesict.activity

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import live.tesnetwork.tesict.IntentHelper
import live.tesnetwork.tesict.components.composable.WorkOrderCard
import live.tesnetwork.tesict.components.composable.baseApp
import live.tesnetwork.tesict.components.composable.invoiceCard
import live.tesnetwork.tesict.components.data.exampleInvoiceData
import live.tesnetwork.tesict.components.data.exampleWorkOrderData

class InvoiceActivity : ComponentActivity(), IntentHelper {
    private var bundle: Bundle? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bundle = savedInstanceState

        val testData = exampleInvoiceData()[intent.getIntExtra("invoiceId", -1)]

        setContent {
            baseApp(intentHelper = this) {
                invoiceCard(testData, this)
            }
        }
    }

    override fun getContext(): Context {
        return this
    }

    override fun getBundle(): Bundle? {
        return bundle
    }
}