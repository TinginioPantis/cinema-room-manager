fun main() {    
    val minHours = readLine()!!.toInt()
    val maxHours = readLine()!!.toInt()
    val annsHours = readLine()!!.toInt()

    println(
        if (annsHours > maxHours) "Excess"
        else if (annsHours < minHours) "Deficiency"
        else "Normal"
    )
}