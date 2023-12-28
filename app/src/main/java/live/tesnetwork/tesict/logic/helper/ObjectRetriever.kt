package live.tesnetwork.tesict.logic.helper

import live.tesnetwork.tesict.components.data.ExampleData
import live.tesnetwork.tesict.components.data.common.WorkOrderData
import live.tesnetwork.tesict.components.data.user.ClientData
import live.tesnetwork.tesict.components.data.user.device.DeviceData

fun Int.getClient(): ClientData {
    return ExampleData.getClient(this)
}

fun Int.getWorkOrder(): WorkOrderData {
    return ExampleData.getWorkOrder(this)
}

fun Int.getDevice(): DeviceData {
    return ExampleData.getDevice(this)
}