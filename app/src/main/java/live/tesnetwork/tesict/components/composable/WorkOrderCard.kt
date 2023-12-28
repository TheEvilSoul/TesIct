package live.tesnetwork.tesict.components.composable

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
import live.tesnetwork.tesict.components.data.ExampleData
import live.tesnetwork.tesict.components.data.common.WorkOrderData
import live.tesnetwork.tesict.components.data.helper.FakeIntentHelperClass
import live.tesnetwork.tesict.components.helper.createLabel
import live.tesnetwork.tesict.logic.helper.getClient
import live.tesnetwork.tesict.logic.helper.getDevice
import live.tesnetwork.tesict.ui.theme.TesICTTheme

@Composable
fun WorkOrderSmallCard(
    workOrderData: WorkOrderData,
    modifier: Modifier = Modifier,
    onClick: (WorkOrderData) -> Unit = {}
) {
    Box(
        modifier = modifier
            .padding(16.dp)
            .fillMaxWidth()
            .background(
                color = MaterialTheme.colorScheme.surface,
                shape = RoundedCornerShape(10.dp)
            )
            .clickable { onClick(workOrderData) }
    ) {
        Column(modifier = modifier.padding(16.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "DeviceName: %s".format(workOrderData.deviceId.getDevice().deviceName),
                    color = MaterialTheme.colorScheme.onSurface
                )
                WorkOrderStatusLabel(workOrderData.status, modifier = Modifier.width(125.dp))
            }
            Text(
                text = workOrderData.title,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                color = MaterialTheme.colorScheme.onSurface
            )
        }
    }
}

@Composable
fun WorkOrderCard(
    workOrderData: WorkOrderData,
    intentHelper: IntentHelper= FakeIntentHelperClass(),
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
                    text = "Name: %s".format(workOrderData.requestData.clientId.getClient().name),
                    color = MaterialTheme.colorScheme.onSurface
                )
                WorkOrderStatusLabel(workOrderData.status, modifier = Modifier.width(125.dp))
            }
            Text(
                text = workOrderData.title,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                color = MaterialTheme.colorScheme.onSurface
            )
            Text(
                text = "Device: %s".format(workOrderData.deviceId.getDevice().deviceName),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                color = MaterialTheme.colorScheme.onSurface
            )
        }
    }
}

@Composable
fun WorkOrderStatusLabel(status: Int, modifier: Modifier = Modifier) {
    when (status) {
        0 -> createLabel(text = "In queue", modifier = modifier)
        1 -> createLabel(text = "In progress", backgroundColor = Color.Magenta, modifier = modifier)
        2 -> createLabel(text = "Is done", backgroundColor = Color.Green, modifier = modifier)

    }
}

@Preview(showBackground = true)
@Composable
fun workOrderSmallCardPreview() {
    val data = ExampleData.getWorkOrder(0)
    TesICTTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.Black)
        ) {
            WorkOrderSmallCard(data)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun workOrderCardPreview() {
    val data = ExampleData.getWorkOrder(0)
    TesICTTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.Black)
        ) {
            WorkOrderCard(data)
        }
    }
}