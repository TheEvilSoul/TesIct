@file:OptIn(
    ExperimentalMaterial3Api::class
)

package live.tesnetwork.tesict.components.composable

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.material3.rememberDrawerState
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.CoroutineScope
import live.tesnetwork.tesict.IntentHelper
import live.tesnetwork.tesict.R
import live.tesnetwork.tesict.components.data.MenuItem
import live.tesnetwork.tesict.components.data.WorkOrderData
import live.tesnetwork.tesict.components.helper.createIcon
import live.tesnetwork.tesict.ui.theme.TesICTTheme
import java.text.SimpleDateFormat

@Composable
fun baseApp(
    intentHelper: IntentHelper?,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    TesICTTheme {
        val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
        val scope = rememberCoroutineScope()

        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            createBaseAppDrawer(drawerState = drawerState,
                scope = scope,
                onItemClick = { item ->
                    if (intentHelper != null) {
                        when (item.id) {
                            "Home" -> intentHelper.gotoHome()
                            "Appointments" -> intentHelper.gotoAppointments()
                            "Invoices" -> intentHelper.gotoInvoices()
                            "WorkOrders" -> intentHelper.gotoWorkOrders()
                            "Devices" -> intentHelper.gotoDevices()
                        }
                    }
                }, content = {
                    createBaseAppBody(
                        modifier = modifier,
                        onNavigationIconClick = {
                            toggleNavBar(
                                drawerState,
                                scope
                            )
                        },
                        content=content
                    )

                }
            )

        }
    }
}

@Composable
fun createBaseAppDrawer(
    drawerState: DrawerState,
    scope: CoroutineScope,
    onItemClick: (MenuItem) -> Unit,
    content: (@Composable () -> Unit) = {}
) {
    val items: List<MenuItem> = listOf(
        MenuItem(
            "Home",
            { createIcon(Icons.Default.Home) },
            "Go to home screen"
        ),
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

    Drawer(drawerState, scope, items, onItemClick = onItemClick, content = content)
}

@Composable
fun createBaseAppBody(
    modifier: Modifier = Modifier,
    onNavigationIconClick: () -> Unit = {},
    content: @Composable () -> Unit
) {
    Column(
        modifier = modifier,
    ) {
        AppBar(onNavigationIconClick = onNavigationIconClick)
        Box(modifier = Modifier.fillMaxSize()) {
            if (content != null) {
                content()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun baseAppPreview() {
    val testData = listOf(
        WorkOrderData(
            workOrderId = 1,
            creationDate = SimpleDateFormat("yyyy-MM-dd").parse("2023-01-01"),
            userId = "user123",
            workerId = "worker456",
            deviceId = 123,
            description = "Example description",
            title = "Example title",
            status = 0,
            invoiceId = 789
        ),
        WorkOrderData(
            workOrderId = 2,
            creationDate = SimpleDateFormat("yyyy-MM-dd").parse("2023-02-01"),
            userId = "user456",
            workerId = "worker789",
            deviceId = 456,
            description = "Another example description",
            title = "Another example title that is longer",
            status = 1,
            invoiceId = 890
        ),
        WorkOrderData(
            workOrderId = 3,
            creationDate = SimpleDateFormat("yyyy-MM-dd").parse("2023-03-01"),
            userId = "user789",
            workerId = "worker012",
            deviceId = 789,
            description = "Yet another example description",
            title = "Yet another example title",
            status = 2,
            invoiceId = 901
        ),
        WorkOrderData(
            workOrderId = 4,
            creationDate = SimpleDateFormat("yyyy-MM-dd").parse("2023-04-01"),
            userId = "user789",
            workerId = "worker012",
            deviceId = 789,
            description = "Example 4 description",
            title = "Example 4 title",
            status = 0,
            invoiceId = 902
        ),
        WorkOrderData(
            workOrderId = 5,
            creationDate = SimpleDateFormat("yyyy-MM-dd").parse("2023-05-01"),
            userId = "user123",
            workerId = "worker456",
            deviceId = 123,
            description = "Example 5 description",
            title = "Example 5 title",
            status = 1,
            invoiceId = 903
        ),
        WorkOrderData(
            workOrderId = 6,
            creationDate = SimpleDateFormat("yyyy-MM-dd").parse("2023-06-01"),
            userId = "user456",
            workerId = "worker789",
            deviceId = 456,
            description = "Example 6 description",
            title = "Example 6 title",
            status = 2,
            invoiceId = 904
        ),
        WorkOrderData(
            workOrderId = 4,
            creationDate = SimpleDateFormat("yyyy-MM-dd").parse("2023-04-01"),
            userId = "user789",
            workerId = "worker012",
            deviceId = 789,
            description = "Example 4 description",
            title = "Example 4 title",
            status = 0,
            invoiceId = 902
        ),
        WorkOrderData(
            workOrderId = 5,
            creationDate = SimpleDateFormat("yyyy-MM-dd").parse("2023-05-01"),
            userId = "user123",
            workerId = "worker456",
            deviceId = 123,
            description = "Example 5 description",
            title = "Example 5 title",
            status = 1,
            invoiceId = 903
        ),
        WorkOrderData(
            workOrderId = 6,
            creationDate = SimpleDateFormat("yyyy-MM-dd").parse("2023-06-01"),
            userId = "user456",
            workerId = "worker789",
            deviceId = 456,
            description = "Example 6 description",
            title = "Example 6 title",
            status = 2,
            invoiceId = 904
        )
    )
    baseApp(intentHelper = null) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            items(testData) { item ->
                WorkOrderSmallCard(item)
            }
        }
    }
}