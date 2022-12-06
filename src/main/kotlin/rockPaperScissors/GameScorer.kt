package rockPaperScissors

class GameScorer {
    fun score(input: String): Int {
        val rounds = input.split("\n")
        return rounds.sumOf { round -> RoundScorer().score(round) }
    }

}
