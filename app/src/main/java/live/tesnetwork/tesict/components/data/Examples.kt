package live.tesnetwork.tesict.components.data

import android.content.Context
import android.os.Bundle
import live.tesnetwork.tesict.IntentHelper
import java.text.SimpleDateFormat
import java.util.Date

fun exampleWorkOrderData(): List<WorkOrderData> {
    return listOf(
        WorkOrderData(
            workOrderId = 0,
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
            workOrderId = 1,
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
            workOrderId = 2,
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
            workOrderId = 3,
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
            workOrderId = 4,
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
            workOrderId = 5,
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
            workOrderId = 6,
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
            workOrderId = 7,
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
            workOrderId = 8,
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
}

fun exampleInvoiceData(): List<InvoiceData> {
    return listOf(
        InvoiceData(
            invoiceId = 0,
            userId = "user123",
            price = 100.0f,
            workOrderId = 0,
            payedStatus = true,
            dueDate = SimpleDateFormat("yyyy-MM-dd").parse("2023-01-15")
        ),
        InvoiceData(
            invoiceId = 1,
            userId = "user456",
            price = 75.5f,
            workOrderId = 1,
            payedStatus = false,
            dueDate = SimpleDateFormat("yyyy-MM-dd").parse("2025-01-15")
        ),
        InvoiceData(
            invoiceId = 2,
            userId = "user789",
            price = 120.75f,
            workOrderId = 2,
            payedStatus = true,
            dueDate = SimpleDateFormat("yyyy-MM-dd").parse("2023-03-10")
        ),
        InvoiceData(
            invoiceId = 3,
            userId = "user012",
            price = 50.25f,
            workOrderId = 3,
            payedStatus = false,
            dueDate = SimpleDateFormat("yyyy-MM-dd").parse("2023-04-05")
        ),
        InvoiceData(
            invoiceId = 4,
            userId = "user345",
            price = 90.0f,
            workOrderId = 4,
            payedStatus = true,
            dueDate = SimpleDateFormat("yyyy-MM-dd").parse("2023-05-15")
        ),
        InvoiceData(
            invoiceId = 5,
            userId = "user678",
            price = 65.8f,
            workOrderId = 5,
            payedStatus = false,
            dueDate = Date()
        ),
        InvoiceData(
            invoiceId = 6,
            userId = "user901",
            price = 150.25f,
            workOrderId = 6,
            payedStatus = true,
            dueDate = SimpleDateFormat("yyyy-MM-dd").parse("2023-07-10")
        ),
        InvoiceData(
            invoiceId = 7,
            userId = "user234",
            price = 80.5f,
            workOrderId = 7,
            payedStatus = false,
            dueDate = SimpleDateFormat("yyyy-MM-dd").parse("2023-08-05")
        ),
        InvoiceData(
            invoiceId = 8,
            userId = "user567",
            price = 110.0f,
            workOrderId = 8,
            payedStatus = true,
            dueDate = SimpleDateFormat("yyyy-MM-dd").parse("2023-09-15")
        )
    )
}

fun exampleUser(): User {
    return User(
        "Jordy",
        "https://lh3.googleusercontent.com/a-/ALV-UjX-UDAOk2czaIvFBmYLyCj4MhEoTbcZ8zctbnAySKyuAQo=s300"
    )
}

class fakeIntentHelperClass: IntentHelper {
    override fun getContext(): Context {
        TODO("This needs to be empty")
    }

    override fun getBundle(): Bundle? {
        TODO("This needs to be empty")
    }

}