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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import live.tesnetwork.tesict.IntentHelper
import live.tesnetwork.tesict.components.data.InvoiceData
import live.tesnetwork.tesict.components.data.exampleInvoiceData
import live.tesnetwork.tesict.components.data.fakeIntentHelperClass
import live.tesnetwork.tesict.components.helper.createLabel
import live.tesnetwork.tesict.logic.helper.getDateAtMidnight
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
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "%s".format(invoiceData.invoiceId),
                    color = MaterialTheme.colorScheme.onSurface
                )
                InvoiceStatusLabel(invoiceData, modifier = Modifier.width(125.dp))
            }
        }
    }
}

@Composable
fun InvoiceStatusLabel(invoiceData: InvoiceData, modifier: Modifier=Modifier) {
    if (invoiceData.payedStatus) {
        createLabel(text = "Payed",backgroundColor = Color.Green, modifier = modifier)
    } else {
        Log.d("InvoiceStatusLabel", invoiceData.dueDate.toString())
        if (invoiceData.dueDate.before(getDateAtMidnight())) {
            createLabel(text = "OverDue", modifier = modifier)
        } else {
            createLabel(text = "Not payed", backgroundColor = Color(0xFFFFA500), modifier = modifier) //Orange
        }
    }
}

@Composable
fun invoiceCard(
    invoiceData: InvoiceData,
    intentHelper: IntentHelper=fakeIntentHelperClass(),
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .padding(16.dp)
            .fillMaxWidth()
            .background(
                color = MaterialTheme.colorScheme.surface,
                shape = RoundedCornerShape(10.dp)
            )
    ) {
        Column(modifier = modifier.padding(16.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Name: %s".format(invoiceData.userId),
                    color = MaterialTheme.colorScheme.onSurface
                )
                InvoiceStatusLabel(invoiceData, modifier = Modifier.width(125.dp))
            }
            Text(
                text = invoiceData.invoiceId.toString(),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                color = MaterialTheme.colorScheme.onSurface
            )
            Text(
                text = "OrderId: %s".format(invoiceData.workOrderId),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                color = MaterialTheme.colorScheme.onSurface,
                modifier=Modifier.clickable { intentHelper.gotoWorkOrder(invoiceData.workOrderId) }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun invoiceSmallCardPreview() {
    val data = exampleInvoiceData()[0]
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
    val data = exampleInvoiceData()[0]
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