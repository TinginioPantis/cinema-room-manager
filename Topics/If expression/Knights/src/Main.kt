import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    val x1 = scanner.nextInt()
    val y1 = scanner.nextInt()
    val x2 = scanner.nextInt()
    val y2 = scanner.nextInt()

    println(if (check(x1, y1, x2, y2)) "YES" else "NO")
}

fun check(x1: Int, y1: Int, x2: Int, y2: Int): Boolean =
    x1 + 1 == x2 && y1 + 2 == y2 || // top right
    x1 - 1 == x2 && y1 + 2 == y2 || // top left
    x1 + 1 == x2 && y1 - 2 == y2 || // bottom right
    x1 - 1 == x2 && y1 - 2 == y2 || // bottom left
    x1 + 2 == x2 && y1 + 1 == y2 || // right top
    x1 + 2 == x2 && y1 - 1 == y2 || // right bottom
    x1 - 2 == x2 && y1 + 1 == y2 || // left top
    x1 - 2 == x2 && y1 - 1 == y2    // left bottom

