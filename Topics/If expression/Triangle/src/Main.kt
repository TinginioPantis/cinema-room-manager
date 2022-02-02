fun main() {
    val a = readLine()!!.toInt()
    val b = readLine()!!.toInt()
    val c = readLine()!!.toInt()

    val isTriangle = (a + b) > c && (a + c) > b && (b + c) > a
    println(if (isTriangle) "YES" else "NO")
}