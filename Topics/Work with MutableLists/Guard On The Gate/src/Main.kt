fun main() {
    val backFromTheWall = readLine()!!.split(", ").map { it }.toMutableList()
    val returnedWatchman = readLine()!!
    // do not touch the lines above
    backFromTheWall.add(returnedWatchman)
    println(backFromTheWall.joinToString())
}