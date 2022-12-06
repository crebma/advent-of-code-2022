package rockPaperScissors

enum class RoundOutcome(val letter: String, val value: Int) {
    Win("Z", 6), Lose("X",0), Draw("Y", 3);

    companion object {
        fun fromLetter(letter: String): RoundOutcome {
            return RoundOutcome.values().first { outcome ->
                outcome.letter == letter
            }
        }
    }
}
