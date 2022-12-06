package rockPaperScissors

enum class Move(
    val value: Int, val letter: String) {
    Rock(1, "A"), Paper(2, "B"), Scissors(3, "C");

    companion object {
        fun fromLetter(letter: String): Move {
            return Move.values().first { theirPlay ->
                theirPlay.letter == letter
            }
        }
    }
}
