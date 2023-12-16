package live.tesnetwork.tesict

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import live.tesnetwork.tesict.activity.HomeActivity

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        gotoHome()
    }

    private fun gotoHome() {
        val intent = Intent(this, HomeActivity::class.java)
        intent.putExtra("key", "With this you can pass data")
        startActivity(intent)
    }
}