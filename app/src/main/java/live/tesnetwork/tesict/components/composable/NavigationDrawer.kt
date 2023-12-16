@file:OptIn(ExperimentalMaterial3Api::class)

package live.tesnetwork.tesict.components.composable

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import live.tesnetwork.tesict.R
import live.tesnetwork.tesict.components.data.MenuItem
import live.tesnetwork.tesict.components.helper.createIcon
import live.tesnetwork.tesict.ui.theme.TesICTTheme


fun toggleNavBar(drawerState: DrawerState, scope: CoroutineScope) {
    scope.launch {
        drawerState.apply { if (isClosed) open() else close() }
    }
}
@Composable
fun Drawer(drawerState: DrawerState, scope: CoroutineScope, items: List<MenuItem>, modifier: Modifier = Modifier, content: (@Composable () -> Unit)?={}, onItemClick: (MenuItem) -> Unit?={}) {
    ModalNavigationDrawer(
        drawerState = drawerState,
        gesturesEnabled = true,
        modifier = modifier,
        drawerContent = {
            ModalDrawerSheet {
                DrawerHeader(modifier=modifier, onClose= {toggleNavBar(drawerState, scope)})
                Divider()
                DrawerBody(items = items, onItemClick = onItemClick)
            }
        }) {
        if (content != null) {
            content()
        }
    }
}

@Composable
fun DrawerHeader(modifier: Modifier = Modifier, onClose: () -> Unit) {
    Row {
        Text(
            "Tes ICT",
            modifier = modifier
                .padding(16.dp)
                .weight(0.5f),
            textAlign = TextAlign.Center
        )
        IconButton(onClick = onClose) {
            Icon(
                modifier= Modifier
                    .padding(1.dp)
                    .weight(1f),
                imageVector = Icons.Default.Close,
                contentDescription = "close drawer"
            )
        }
    }
}

@Composable
fun DrawerBody(items: List<MenuItem>, onItemClick: (MenuItem) -> Unit?={}) {
        for (item in items) {
            defaultDrawerItem(
                label = item.title,
                icon = item.icon,
                onClick = {onItemClick(item)}
            )
        }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun defaultDrawerItem(
    label: String,
    icon: (@Composable () -> Unit)? = null,
    onClick: () -> Unit = {}
) {
    NavigationDrawerItem(
        icon = icon,
        label = { Text(text = label) },
        selected = false,
        onClick = onClick
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun drawerNavBar(drawerState: DrawerState, scope: CoroutineScope, modifier: Modifier = Modifier) {
    ModalNavigationDrawer(
        drawerState = drawerState,
        gesturesEnabled = true,
        modifier = modifier,
        drawerContent = {
            ModalDrawerSheet {
                Row (modifier=Modifier.fillMaxWidth()){
                    Text(
                        "Tes ICT",
                        modifier = modifier.padding(16.dp).weight(weight=1f, fill = true),
                        textAlign = TextAlign.Center
                    )
                    IconButton(modifier=modifier, onClick = {
                        toggleNavBar(
                            drawerState,
                            scope
                        )
                    }) {
                        Icon(
                            imageVector = Icons.Default.Close,
                            contentDescription = null
                        )
                    }
                }
                Divider()
                defaultDrawerItem(label = "Home", icon = { createIcon(Icons.Default.Home) })
                defaultDrawerItem(
                    label = "Appointments",
                    icon = { createIcon(Icons.Default.DateRange) })
                defaultDrawerItem(
                    label = "Invoices",
                    icon = { createIcon(R.drawable.outline_receipt_long_24) })
                defaultDrawerItem(label = "WorkOrders", icon = { createIcon(Icons.Default.List) })
                defaultDrawerItem(
                    label = "Devices",
                    icon = { createIcon(R.drawable.outline_devices_24) })

            }
        }
    ) {
        // Screen content
    }
}

@Preview(showBackground = true)
@Composable
fun drawerPreview() {
    TesICTTheme {
        Surface (modifier = Modifier.fillMaxSize()){
            val drawerState = rememberDrawerState(initialValue = DrawerValue.Open)
            val scope = rememberCoroutineScope()
            drawerNavBar(drawerState, scope)
        }
    }
}

