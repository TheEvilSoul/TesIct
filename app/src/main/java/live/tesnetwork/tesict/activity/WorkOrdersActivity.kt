package live.tesnetwork.tesict.activity

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.ui.Modifier
import live.tesnetwork.tesict.IntentHelper
import live.tesnetwork.tesict.components.composable.WorkOrderSmallCard
import live.tesnetwork.tesict.components.composable.baseApp
import live.tesnetwork.tesict.components.data.ExampleData

class WorkOrdersActivity : ComponentActivity(), IntentHelper {
    private var bundle: Bundle? = null

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bundle = savedInstanceState

        val testData = ExampleData.getWorkOrders()

        setContent {
            baseApp(intentHelper = this) {
                LazyColumn(
                    modifier = Modifier
                ) {
                    items(testData) { item ->
                        WorkOrderSmallCard(item, onClick = {
                            gotoWorkOrder(it.workOrderId)
                        })
                    }
                }
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