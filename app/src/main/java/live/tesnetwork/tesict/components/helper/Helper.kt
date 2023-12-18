package live.tesnetwork.tesict.components.helper

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun createIcon(icon: ImageVector, contentDescription: String? = null) {
    Icon(imageVector = icon, contentDescription = contentDescription)
}

@Composable
fun createIcon(icon: Int, contentDescription: String? = null) {
    Icon(painter = painterResource(id = icon), contentDescription = contentDescription)
}

@Composable
fun createLabel(text: String, backgroundColor: Color = Color.Red, shape: Shape= RoundedCornerShape(16.dp), modifier: Modifier = Modifier, textColor: Color = Color.White) {
    Box(modifier = Modifier.background(color= backgroundColor, shape = shape)) {
        Text(text = text, modifier = modifier.padding(10.dp).fillMaxWidth(), color = textColor, textAlign = TextAlign.Center)
    }
}