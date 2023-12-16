package live.tesnetwork.tesict.activity

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import live.tesnetwork.tesict.IntentHelper
import live.tesnetwork.tesict.components.composable.baseApp

class AppointmentsActivity : ComponentActivity(), IntentHelper {
    private var bundle: Bundle? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bundle=savedInstanceState
        setContent {
            baseApp(this, content = {
                Text(text = "Appointments Screen")
            })
        }
    }

    override fun getContext(): Context {
        return this
    }

    override fun getBundle(): Bundle? {
        return bundle
    }
}