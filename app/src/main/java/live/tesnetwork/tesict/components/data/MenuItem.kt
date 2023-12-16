package live.tesnetwork.tesict.components.data

import androidx.compose.runtime.Composable

data class MenuItem(
    val title: String,
    val icon: (@Composable () -> Unit)? = null,
    val contentDescription: String?=null,
    val id: String=title
)
