package rockPaperScissors

enum class Move(
    val value: Int, val letters: List<String>) {
    Rock(1, listOf("A", "X")), Paper(2, listOf("B", "Y")), Scissors(
        3, listOf("C", "Z")
    );

    companion object {
        fun fromLetter(letter: String): Move {
            return Move.values().first { theirPlay ->
                theirPlay.letters.contains(letter)
            }
        }
    }
}
