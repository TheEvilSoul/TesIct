package live.tesnetwork.tesict.components.data

import java.text.SimpleDateFormat

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

fun exampleUser(): User {
    return User(
        "Jordy",
        "https://lh3.googleusercontent.com/a-/ALV-UjX-UDAOk2czaIvFBmYLyCj4MhEoTbcZ8zctbnAySKyuAQo=s300"
    )
}