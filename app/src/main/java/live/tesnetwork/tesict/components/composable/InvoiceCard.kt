package live.tesnetwork.tesict.components.composable

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import live.tesnetwork.tesict.IntentHelper
import live.tesnetwork.tesict.components.data.ExampleData
import live.tesnetwork.tesict.components.data.helper.FakeIntentHelperClass
import live.tesnetwork.tesict.components.data.invoice.InvoiceData
import live.tesnetwork.tesict.components.data.invoice.InvoiceItem
import live.tesnetwork.tesict.components.data.invoice.InvoiceItemProduct
import live.tesnetwork.tesict.components.data.invoice.InvoiceItemWorkOrder
import live.tesnetwork.tesict.components.helper.createLabel
import live.tesnetwork.tesict.logic.helper.getClient
import live.tesnetwork.tesict.logic.helper.getDateAtMidnight
import live.tesnetwork.tesict.logic.helper.toNormalDateString
import live.tesnetwork.tesict.ui.theme.TesICTTheme

@Composable
fun invoiceSmallCard(
    invoiceData: InvoiceData,
    modifier: Modifier = Modifier,
    onClick: (InvoiceData) -> Unit = {}
) {
    Box(
        modifier = modifier
            .padding(16.dp)
            .fillMaxWidth()
            .background(
                color = MaterialTheme.colorScheme.surface,
                shape = RoundedCornerShape(10.dp)
            )
            .clickable { onClick(invoiceData) }
    ) {
        Column(modifier = modifier.padding(16.dp)) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 10.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "InvoiceId: %s".format(invoiceData.invoiceId),
                    color = MaterialTheme.colorScheme.onSurface
                )
                InvoiceStatusLabel(invoiceData, modifier = Modifier.width(125.dp))
            }
            Text(
                text = "DueDate: %s".format(invoiceData.dueDate.toNormalDateString()),
                color = MaterialTheme.colorScheme.onSurface
            )
        }
    }
}

@Composable
fun InvoiceStatusLabel(invoiceData: InvoiceData, modifier: Modifier = Modifier) {
    if (invoiceData.payedStatus) {
        createLabel(text = "Payed", backgroundColor = Color.Green, modifier = modifier)
    } else {
        Log.d("InvoiceStatusLabel", invoiceData.dueDate.toString())
        if (invoiceData.dueDate.before(getDateAtMidnight())) {
            createLabel(text = "OverDue", modifier = modifier)
        } else {
            createLabel(
                text = "Not payed",
                backgroundColor = Color(0xFFFFA500), //Orange
                modifier = modifier
            )
        }
    }
}

@Composable
fun invoiceCardOld(
    invoiceData: InvoiceData,
    intentHelper: IntentHelper = FakeIntentHelperClass(),
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier
            .padding(16.dp)
            .fillMaxWidth()
            .background(
                color = MaterialTheme.colorScheme.surface,
                shape = RoundedCornerShape(10.dp)
            )
    ) {
        Column(modifier = modifier.padding(16.dp)) {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "INVOICE",
                textAlign = TextAlign.Center,
                fontSize = MaterialTheme.typography.titleLarge.fontSize
            )
            Divider(modifier = Modifier.padding(vertical = 10.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(
                        text = "Name: %s".format(invoiceData.clientId.getClient().name)
                    )
                    Text(
                        text = "ClientId: %s".format(invoiceData.clientId)
                    )
                }
                InvoiceStatusLabel(invoiceData, modifier = Modifier.width(125.dp))
            }
            Text(
                text = "InvoiceId: %s".format(invoiceData.invoiceId),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

            invoiceData.items.forEach { invoiceItem ->
                invoiceItemCard(invoiceItem)
            }
        }
    }
}

@Composable
fun invoiceCard(
    invoiceData: InvoiceData,
    intentHelper: IntentHelper = FakeIntentHelperClass(),
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier
            .padding(16.dp)
            .fillMaxWidth()
            .background(
                color = MaterialTheme.colorScheme.surface,
                shape = RoundedCornerShape(10.dp)
            )
    ) {
        LazyColumn(
            modifier = modifier.padding(16.dp),
            content = {
                item {
                    Column {
                        Text(
                            modifier = Modifier.fillMaxWidth(),
                            text = "INVOICE",
                            textAlign = TextAlign.Center,
                            fontSize = MaterialTheme.typography.titleLarge.fontSize
                        )
                        Divider(modifier = Modifier.padding(vertical = 10.dp))
                        Row() {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .weight(0.5f),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Column {
                                    Text(
                                        text = "Name: %s".format(invoiceData.clientId.getClient().name)
                                    )
                                    Text(
                                        text = "ClientId: %s".format(invoiceData.clientId)
                                    )
                                }
                            }
                            InvoiceStatusLabel(invoiceData, modifier = Modifier.width(125.dp))
                        }
                        Row (verticalAlignment = Alignment.CenterVertically){
                            Column (){
                                Text(
                                    text = "InvoiceId: %s".format(invoiceData.invoiceId),
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis
                                )
                                Text(
                                    text = "Due date: %s".format(invoiceData.dueDate.toNormalDateString()),
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis
                                )
                            }

                            Text(
                                modifier = Modifier.weight(0.5f).fillMaxWidth(),
                                text = "%s euro".format(invoiceData.getPrice()),
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis,
                                textAlign = TextAlign.End,
                                fontSize = MaterialTheme.typography.titleMedium.fontSize * 1.2f
                            )
                        }
                        Divider(Modifier.padding(vertical = 10.dp))
                    }
                }
                items(invoiceData.items) { item ->
                    invoiceItemCard(item, Modifier.padding(5.dp))
                }
            }
        )
    }
}

@Composable
fun invoiceItemCard(invoiceItem: InvoiceItem, modifier: Modifier = Modifier) {
    var isExpanded by remember { mutableStateOf(false) }
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(
                color = MaterialTheme.colorScheme.background,
                shape = RoundedCornerShape(10.dp)
            )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
                .clickable {
                    isExpanded = !isExpanded
                },
            verticalAlignment = Alignment.CenterVertically

        ) {
            Text(text = invoiceItem.getTitle(), overflow = TextOverflow.Ellipsis, modifier=modifier.fillMaxWidth().weight(0.5f))
            Text(text = "Price: %s".format(invoiceItem.getPrice()))
            Icon(
                if (isExpanded) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                contentDescription = "Toggle Box",
                modifier = Modifier
                    .padding(2.dp)

            )
        }
        if (isExpanded) {
            Divider(Modifier.padding(8.dp))
            if (invoiceItem is InvoiceItemWorkOrder) invoiceItemCardWorkOrder(
                invoiceItem,
                modifier.padding(5.dp)
            )
            else if (invoiceItem is InvoiceItemProduct) invoiceItemCardBase(
                invoiceItem,
                modifier.padding(5.dp)
            )
        }
    }

}

@Composable
fun invoiceItemCardBase(invoiceItem: InvoiceItem, modifier: Modifier = Modifier, content: (@Composable () -> Unit)? = null) {
    Box(
        modifier = modifier
    ) {
        Column {
            Text(text = "Price per unit: %s".format(invoiceItem.getUnitPrice()))
            Text(text = "Quantity: %s".format(invoiceItem.getQuantity()))
            Text(text = "VAT: %s%%".format(invoiceItem.getVAT()))
            Text(text = "Total price: %s".format(invoiceItem.getPrice()))
            if (content == null) {
                Text(text = invoiceItem.getDescription())
            } else {
                content()
            }
        }
    }
}

@Composable
fun invoiceItemCardWorkOrder(invoiceItem: InvoiceItemWorkOrder, modifier: Modifier = Modifier) {
    invoiceItemCardBase (invoiceItem, modifier) {
        Text(text = "WorkOrderId: %s".format(invoiceItem.getWorkOrder().workOrderId))
        Text(text = invoiceItem.getDescription())
    }
}

@Preview(showBackground = true)
@Composable
fun invoiceItemCard() {
    var data = ExampleData.getInvoice(0).items[0]
    TesICTTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.Black)
        ) {
            Surface(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                    .background(
                        color = MaterialTheme.colorScheme.surface,
                        shape = RoundedCornerShape(10.dp)
                    )
            ) {
                invoiceItemCard(data)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun invoiceSmallCardPreview() {
    val data = ExampleData.getInvoice(0)
    TesICTTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.Black)
        ) {
            invoiceSmallCard(data)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun invoiceCardPreview() {
    val data = ExampleData.getInvoice(0)
    TesICTTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.Black)
        ) {
            invoiceCard(data)
        }
    }
}