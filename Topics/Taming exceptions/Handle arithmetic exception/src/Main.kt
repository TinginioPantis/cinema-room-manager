fun main() {
    val number1 = readLine()!!.toInt()
    val number2 = readLine()!!.toInt()
    if (number2 == 0) {
        println("Division by zero, please fix the second argument!")
    } else println(number1 / number2)
}