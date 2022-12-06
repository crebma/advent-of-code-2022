class HighestCalorieFinder {
    fun highest(input: String): Int {
        return sortedElfTotals(input).last()
    }

    fun topThreeTotal(input: String): Int {
        return sortedElfTotals(input).takeLast(3).sum()
    }

    private fun sortedElfTotals(input: String) = ElfTotaler().totals(input).sorted()
}
