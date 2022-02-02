fun isVowel (letter: Char): Boolean {
    return letter in "A, E, I, O, U, a, e, i, o, u"
}
fun main() {
    val letter = readLine()!!.first()

    println(isVowel(letter))
}