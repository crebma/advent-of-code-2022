package crates

class RearrangementProcedure(procedureText: String) {

    private val numbers =
        procedureText.split(" ")
                     .filter { word -> word.toIntOrNull() != null }
                     .map { word -> word.toInt() }

    val quantity: Int = numbers[0]

    val from: Int = numbers[1]

    val to: Int = numbers[2]
}
