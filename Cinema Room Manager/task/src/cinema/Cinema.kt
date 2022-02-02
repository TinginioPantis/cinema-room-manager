package cinema

typealias SeatTaken = Boolean
typealias Row = MutableList<SeatTaken>
typealias Cinema = MutableList<Row>

fun main() {
    println("Enter the number of rows:")
    val rows = readInt()
    println("Enter the number of seats in each row:")
    val seats = readInt()
    val cinema = createCinema(rows, seats)
    println()
    runUntilUserExits(seats, cinema)
}

fun printMenu() {
    println("1. Show the seats")
    println("2. Buy a ticket")
    println("3. Statistics")
    println("0. Exit")
}

fun statistics(cinema: Cinema, seats: Int) {
    val rows = cinema.size
    val noOfPurchasedTickets = calculateNoOfPurchasedTickets(cinema)
    val totalNumberOfSeats = calculateTotalNumberOfSeats(rows, seats)
    val percentageOfPurchasedTickets = percentageOfPurchasedTickets(
            totalNumberOfSeats = totalNumberOfSeats, numberOfTakenSeats = noOfPurchasedTickets
    )
    val percentageOfPurchasedTicketsStr =
        "%.2f%%".format(percentageOfPurchasedTickets * 100)

    println("Number of purchased tickets: $noOfPurchasedTickets")
    println("Percentage: $percentageOfPurchasedTicketsStr")
    println("Current income: $${currentIncome(cinema)}")
    println("Total income: $${totalIncome(rows, seats)}")
}

fun calculateNoOfPurchasedTicketsInRow(row: Row): Int =
    row.count { it }

fun calculateNoOfPurchasedTickets(cinema: Cinema): Int =
    cinema.sumOf { row -> calculateNoOfPurchasedTicketsInRow(row) }

fun percentageOfPurchasedTickets(totalNumberOfSeats: Int, numberOfTakenSeats: Int): Double =
    numberOfTakenSeats / totalNumberOfSeats.toDouble()

fun calculateTotalNumberOfSeats(rows: Int, seats: Int): Int = rows * seats

/**
 * This function calculates income from the taken seats in the given row.
 *
 * @param row The row that we are calculating income for.
 * @param rows Total number of rows in the cinema.
 * @param rowNumber Number of the row that we are calculating income for. Starts from 1.
 */
fun currentRowIncome(row: Row, rows: Int, rowNumber: Int): Int =
    calculateNoOfPurchasedTicketsInRow(row) * calculateTicketPrice(
        rows, rowNumber, seats = row.size
    )

/**
 * This function calculates income from all taken seats at the moment.
 */
fun currentIncome(cinema: Cinema): Int {
    var sum = 0
    for (rowIdx in cinema.indices) {
        sum += currentRowIncome(cinema[rowIdx], rows = cinema.size, rowNumber = rowIdx + 1)
    }
    return sum
}

//fun totalIncome2(cinema: Cinema): Int {
//    // O(n) - linear time
//    return cinema.indices.sumOf { rowIdx ->
//        val row = cinema[rowIdx]
//        val seats = row.size
//        val incomePerSeat = calculateTicketPrice(
//                rows = cinema.size, rowNumber = rowIdx + 1, seats = seats
//        )
//        seats * incomePerSeat
//    }
//}

fun totalIncome(rows: Int, seats: Int): Int {
    // O(1) - constant time
    val totalNumberOfSeats = calculateTotalNumberOfSeats(rows, seats)
    val totalIncome =
            if (totalNumberOfSeats > 60)
                rows / 2 * 10 * seats + (rows / 2 + rows % 2) * 8 * seats
            else totalNumberOfSeats * 10
    return totalIncome
}

fun runUntilUserExits(seats: Int, cinema: Cinema) {
    var userWantsToExit = false
    while (!userWantsToExit) {
        printMenu()
        val chosenAnswer = readLine()!!
        println()
        when (chosenAnswer) {
            "1", "1." -> {
                printCinemaLayout(cinema)
                println()
            }
            "2", "2." -> {
                buyTicket(seats, cinema)
                println()
            }
            "3", "3." -> {
                statistics(cinema, seats)
                println()
            }
            "0", "0." -> userWantsToExit = true
            else -> println("Choose a number from the menu!")
        }
    }
}

fun buyTicket(seats: Int, cinema: Cinema) {
    val rows = cinema.size

    if (calculateNoOfPurchasedTickets(cinema) == calculateTotalNumberOfSeats(rows, seats)) {
        println("Apologies, all tickets are sold.")
    }
    else {
        println("Enter a row number:")
        val rowNumber = readInt()
        println("Enter a seat number in that row:")
        val seatNumber = readInt()

        if (rowNumber < 1 || rowNumber > rows || seatNumber < 1 || seatNumber > seats) {
            println("Wrong input!")
            buyTicket(seats, cinema)
        } else if (cinema[rowNumber - 1][seatNumber - 1]) {
            println("That ticket has already been purchased!")
            println("Choose different seat.")
            buyTicket(seats, cinema)
        } else {
            val ticketPrice = calculateTicketPrice(rows, rowNumber, seats)
            println("Ticket price: $$ticketPrice")
            markSeatAsTaken(cinema, rowNumber, seatNumber)
        }
    }
}

fun readInt(): Int = readLine()!!.toInt()

fun calculateTicketPrice(rows: Int, rowNumber: Int, seats: Int): Int {
    val totalNumberOfSeats = calculateTotalNumberOfSeats(rows, seats)
    if (totalNumberOfSeats < 60)
        return 10
    else {
        val frontRows = rows / 2
        return if (rowNumber <= frontRows) 10 else 8
    }
}

fun markSeatAsTaken(cinema: Cinema, rowNumber: Int, seatNumber: Int) {
    cinema[rowNumber - 1][seatNumber - 1] = true
}

fun createCinema(rows: Int, seats: Int): Cinema {
    return MutableList(rows) { MutableList(seats) { false } }
}

fun printCinemaLayout(cinema: Cinema) {
    println("Cinema:")
    for (rowIdx in cinema.indices) {
        val row = cinema[rowIdx]
        if (rowIdx == 0) {
            println("  ${row.indices.map { it + 1 }.joinToString(" ")}")
        }
        println("${rowIdx + 1} ${row.joinToString(" ") { if (it) "B" else "S" }}")
    }
}