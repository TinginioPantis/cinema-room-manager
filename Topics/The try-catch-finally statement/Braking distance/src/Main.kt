import kotlin.Exception        

fun calculateBrakingDistance(v1Str: String, aStr: String): Int {
    return try {
        val v2 = 0
        val v1 = v1Str.toInt()
        val a = aStr.toInt()
        val s = ((v2 * v2) - (v1 * v1)) / (2 * a)
        s
    }
    catch (e: ArithmeticException) {
        println("The car does not slow down!")
        -1
    }
    catch (e: Exception) {
        println(e.message)
        -1
    }
}