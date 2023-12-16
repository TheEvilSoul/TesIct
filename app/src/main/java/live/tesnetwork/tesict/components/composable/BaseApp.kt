@file:OptIn(ExperimentalMaterial3Api::class)

package live.tesnetwork.tesict.components.composable

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.tooling.preview.Preview
import live.tesnetwork.tesict.R
import live.tesnetwork.tesict.components.data.MenuItem
import live.tesnetwork.tesict.components.helper.createIcon
import live.tesnetwork.tesict.ui.theme.TesICTTheme

@Composable
fun baseApp(modifier: Modifier = Modifier, content: (@Composable () -> Unit)?={}) {
    TesICTTheme {
        val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
        val scrollBehavior =
            TopAppBarDefaults.exitUntilCollapsedScrollBehavior(rememberTopAppBarState())
        val scope = rememberCoroutineScope()
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            val items: List<MenuItem> = listOf(
                MenuItem("Home", { createIcon(Icons.Default.Home) }, "Go to home screen"),
                MenuItem(
                    "Appointments",
                    { createIcon(Icons.Default.DateRange) },
                    "Go to appointments screen"
                ),
                MenuItem(
                    "Invoices",
                    { createIcon(R.drawable.outline_receipt_long_24) },
                    "Go to invoices screen"
                ),
                MenuItem(
                    "WorkOrders",
                    { createIcon(Icons.Default.List) },
                    "Go to work orders screen"
                ),
                MenuItem(
                    "Devices",
                    { createIcon(R.drawable.outline_devices_24) },
                    "Go to devices screen"
                ),
            )
            Drawer(drawerState, scope, items, content = {
                Scaffold(
                    modifier = modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
                    topBar = {
                        AppBar(onNavigationIconClick = {
                            toggleNavBar(
                                drawerState,
                                scope
                            )
                        })
                    },
                ) { innerPadding ->
                    Surface(
                        color = MaterialTheme.colorScheme.background, modifier = modifier
                            .padding(top = innerPadding.calculateTopPadding())
                            .fillMaxSize()
                    ) {
                        if (content != null) {
                            content()
                        }
                    }
                }
            })
        }
    }
}

@Preview(showBackground = true)
@Composable
fun baeAppPreview() {
    baseApp()
}