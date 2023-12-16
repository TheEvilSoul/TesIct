package live.tesnetwork.tesict.components.helper

import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource

@Composable
fun createIcon(icon: ImageVector, contentDescription: String? = null) {
    Icon(imageVector = icon, contentDescription = contentDescription)
}

@Composable
fun createIcon(icon: Int, contentDescription: String? = null) {
    Icon(painter = painterResource(id = icon), contentDescription = contentDescription)
}