fun main() {
    //Do not touch code below
    var inputList: MutableList<MutableList<String>> = mutableListOf()
    val n = readLine()!!.toInt()
    for (i in 0 until n) {
        val strings = readLine()!!.split(' ').toMutableList()
        inputList.add(strings)
    }
    //write your code here
    println("${inputList.first().first()} ${inputList.first().last()}")
    println("${inputList.last().first()} ${inputList.last().last()}")

//    println(inputList[0].first() + " " + inputList[0].last())
//    println(inputList[n - 1].first() + " " + inputList[n - 1].last())

}