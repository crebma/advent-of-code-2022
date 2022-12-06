class CalorieTotaler {
    fun total(input: String): Int {
        val numbers = input.split("\n")
        return numbers.sumOf { number -> Integer.parseInt(number) }
    }
}
