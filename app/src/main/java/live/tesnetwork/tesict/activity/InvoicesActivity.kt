package live.tesnetwork.tesict.activity

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import live.tesnetwork.tesict.IntentHelper
import live.tesnetwork.tesict.components.composable.baseApp

class InvoicesActivity : ComponentActivity(), IntentHelper {
    private var bundle: Bundle? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bundle = savedInstanceState
        val testData = listOf("Invoices Screen")
        setContent {
            baseApp(intentHelper = this) {
                LazyColumn(
                    modifier = Modifier
                ) {
                    items(testData) { item ->
                        Text(text = item)
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