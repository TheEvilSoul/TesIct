package live.tesnetwork.tesict.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import live.tesnetwork.tesict.components.composable.baseApp

class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            baseApp(content = {
                Text(text = "Home Screen")
            })
        }
    }
}