fun main() {
    val n = readLine()!!.toInt()
    val items = MutableList<Int>(n) { readLine()!!.toInt() }
    val m = readLine()!!.toInt()
    if (items.contains(m)) {
        println("YES")
    } else println("NO")
}