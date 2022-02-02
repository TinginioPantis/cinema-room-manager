fun parseCardNumber(cardNumber: String): Long {
    // patikrini ilgi: .length == N
    // patikrini spaces: cardNumber[X] == ' '
    // jei ne, ismeti exception su throw RuntimeException("klaida")
    // ismeti spaces ir pavert i long:
    if (cardNumber.length == 19 && cardNumber[4] == ' ' && cardNumber[9] == ' ' && cardNumber[14] == ' ') {
        return cardNumber.replace(" ", "").toLong()
    } else throw Exception("Error!")
}