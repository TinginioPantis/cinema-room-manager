fun intDivision(x: String, y: String): Int {
    try {
        val xToNumber = x.toInt()
        val yToNumber = y.toInt()
        return xToNumber / yToNumber
    }
    catch (e: ArithmeticException) {
        println("Exception: division by zero!")
    }
    catch (e: NumberFormatException) {
        println("Read values are not integers.")
    }
    return 0
}

fun main() {
    val x = readLine()!!
    val y = readLine()!!
    println(intDivision(x, y))

}