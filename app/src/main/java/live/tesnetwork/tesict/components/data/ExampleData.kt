package live.tesnetwork.tesict.components.data

import live.tesnetwork.tesict.components.data.common.RequestData
import live.tesnetwork.tesict.components.data.common.WorkOrderData
import live.tesnetwork.tesict.components.data.invoice.InvoiceData
import live.tesnetwork.tesict.components.data.invoice.InvoiceItem
import live.tesnetwork.tesict.components.data.invoice.InvoiceItemProduct
import live.tesnetwork.tesict.components.data.invoice.InvoiceItemWorkOrder
import live.tesnetwork.tesict.components.data.user.ClientData
import live.tesnetwork.tesict.components.data.user.ProfileData
import live.tesnetwork.tesict.components.data.user.device.DeviceData
import java.util.Date
import kotlin.random.Random

class ExampleData {
    companion object {
        private val clients: List<ClientData>
        private val devices: List<DeviceData>
        private val workOrders: List<WorkOrderData>
        private val invoices: List<InvoiceData>
        private val invoiceItemProducts: List<InvoiceItemProduct>
        private val invoiceItemWorkOrders: List<InvoiceItemWorkOrder>
        init {
            clients = createClients()
            devices = createDevices()
            workOrders = createWorkOrders()
            invoiceItemProducts = createInvoiceItemProducts()
            invoiceItemWorkOrders = createInvoiceItemWorkOrders()
            invoices = createInvoiceData()
        }

        private fun createInvoiceItemWorkOrders(): List<InvoiceItemWorkOrder> {
            var result = ArrayList<InvoiceItemWorkOrder>()
            for (i in 1 until 10) {
                result.add(
                    InvoiceItemWorkOrder(
                        i,
                        getRandomWorkOrder(),
                        1
                    )
                )
            }
            return result
        }

        private fun createInvoiceItemProducts(): List<InvoiceItemProduct> {
            var result = ArrayList<InvoiceItemProduct>()
            for (i in 1 until 10) {
                result.add(
                    InvoiceItemProduct(
                        i,
                        "title$i",
                        "description$i",
                        1,
                        1f,
                        6f
                    )
                )
            }
            return result
        }

        private fun createClients(): List<ClientData> {
            var result = ArrayList<ClientData>()
            result.add(
                ClientData(
                    0,
                    "Jordy",
                    ProfileData("https://lh3.googleusercontent.com/a-/ALV-UjX-UDAOk2czaIvFBmYLyCj4MhEoTbcZ8zctbnAySKyuAQo=s300")
                )
            )
            for (i in 1 until 4) {
                result.add(
                    ClientData(
                        i,
                        "client$i",
                        ProfileData("empty")
                    )
                )
            }
            return result
        }

        private fun createDevices(): List<DeviceData> {
            var result = ArrayList<DeviceData>()
            for (i in 0 until 10) {
                result.add(
                    DeviceData(
                        i,
                        "device$i",
                        getRandomClientId(),
                        getRandomDeviceOs()
                    )
                )
            }
            return result
        }

        private fun createWorkOrders(): List<WorkOrderData> {
            var result = ArrayList<WorkOrderData>()
            for (i in 0 until 10) {
                result.add(
                    WorkOrderData(
                        i,
                        Date(),
                        RequestData(
                            "Request title$i",
                            "Request description$i",
                            getRandomClientId()
                        ),
                        getRandomWorkerId(),
                        getRandomDeviceId(),
                        getRandomStatus()
                    )
                )
            }
            return result
        }

        private fun createInvoiceData(): List<InvoiceData> {
            var result = ArrayList<InvoiceData>()
            for (i in 0 until 20) {
                val invoiceItem = getRandomInvoiceItem()
                var clientId: Int = getRandomClientId()
                if (invoiceItem is InvoiceItemWorkOrder) {
                    clientId = invoiceItem.getWorkOrder().requestData.clientId
                }
                val invoiceItems = mutableListOf(invoiceItem)
                for (i in 0 until Random.nextInt(0, 10)) {
                    invoiceItems.add(getRandomInvoiceItemProduct())
                }
                result.add(
                    InvoiceData(
                        i,
                        clientId,
                        invoiceItems,
                        getRandomBoolean(),
                        Date()
                    )
                )
            }
            return result
        }

        private fun getRandomClientId(): Int {
            return clients.random().clientId
        }

        private fun getRandomWorkerId(): Int {
            return 0
        }

        private fun getRandomDeviceId(): Int {
            return 0
        }

        private fun getRandomStatus(): Int {
            return 0
        }

        private fun getRandomDeviceOs(): Int {
            return 0
        }

        private fun getRandomWorkOrder(): WorkOrderData {
            return workOrders.random()
        }

        private fun getRandomInvoiceItemWorkOrder(): InvoiceItemWorkOrder {
            return invoiceItemWorkOrders.random()
        }

        private fun getRandomInvoiceItemProduct(): InvoiceItemProduct {
            return invoiceItemProducts.random()
        }

        private fun getRandomInvoiceItem(): InvoiceItem {
            if (Random.nextBoolean()) return getRandomInvoiceItemProduct()
            return getRandomInvoiceItemWorkOrder()
        }

        private fun getRandomBoolean(): Boolean {
            return Random.nextBoolean()
        }


        fun getClients(): List<ClientData> {
            return clients
        }

        fun getClient(id: Int): ClientData {
            return clients[id]
        }

        fun getWorkOrders(): List<WorkOrderData> {
            return workOrders
        }

        fun getWorkOrder(id: Int): WorkOrderData {
            return workOrders[id]
        }

        fun getDevices(): List<DeviceData> {
            return devices
        }

        fun getDevice(id: Int): DeviceData {
            return devices[id]
        }

        fun getInvoices(): List<InvoiceData> {
            return invoices
        }

        fun getInvoice(id: Int): InvoiceData {
            return invoices[id]
        }
    }
}
