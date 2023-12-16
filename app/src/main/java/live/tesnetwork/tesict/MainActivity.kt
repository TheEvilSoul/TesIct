package live.tesnetwork.tesict

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity(), IntentHelper {
    private var bundle: Bundle? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bundle=savedInstanceState
        gotoHome()
    }

    override fun getContext(): Context {
        return this
    }

    override fun getBundle(): Bundle? {
        return bundle;
    }
}