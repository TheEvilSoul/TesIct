package live.tesnetwork.tesict.activity

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import live.tesnetwork.tesict.IntentHelper
import live.tesnetwork.tesict.components.composable.WorkOrderCard
import live.tesnetwork.tesict.components.composable.baseApp
import live.tesnetwork.tesict.components.data.ExampleData

class WorkOrderActivity : ComponentActivity(), IntentHelper {
    private var bundle: Bundle? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bundle = savedInstanceState

        val testData = ExampleData.getWorkOrder(intent.getIntExtra("workOrderId", -1))

        setContent {
            baseApp(intentHelper = this) {
                WorkOrderCard(workOrderData = testData)
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