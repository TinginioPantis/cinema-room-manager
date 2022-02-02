import java.util.*
import kotlin.math.abs

fun main() {
    val scanner = Scanner(System.`in`)
    val x1 = scanner.nextInt()
    val y1 = scanner.nextInt()
    val x2 = scanner.nextInt()
    val y2 = scanner.nextInt()
    println(if (twoQueensSeeEachOther(x1, y1, x2, y2)) "YES" else "NO")
}

// https://stackoverflow.com/a/66860755
fun twoQueensSeeEachOther(x1: Int, y1: Int, x2: Int, y2: Int): Boolean {
    val sameRow = y1 == y2
    val sameColumn = x1 == x2
    val onDiagonal = abs(x1 - x2) == abs(y1 - y2)
    return sameRow || sameColumn || onDiagonal
}