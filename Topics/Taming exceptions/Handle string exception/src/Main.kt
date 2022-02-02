fun main() {
    val index = readLine()!!.toInt()
    val word = readLine()!!

    println(
        if (word.indices.contains(index)) {
            val char = word[index]
            char.toString()
        }
        else "There isn't such an element in the given string, please fix the index!"
    )
}