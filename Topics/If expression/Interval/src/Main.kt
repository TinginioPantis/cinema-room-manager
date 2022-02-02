fun main() {
    val number = readLine()!!.toInt()
    if (number > -15 && number <= 12 || number > 14 && number < 17 || number >= 19) {
        println("True")
    } else {
        println("False")
    }
}