fun main() {
    val number = readLine()!!.toInt()
    if (number < 0) {
        println("negative")
    }
    if (number > 0) {
        println("positive")
    }
    if (number == 0) {
        println("zero")
    }
}