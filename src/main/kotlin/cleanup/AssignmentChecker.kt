package cleanup

class AssignmentChecker {
    companion object {
        fun overlaps(assignments: String): Boolean {
            val (first, second) = assignments.split(",")
            val (firstStart, firstEnd) = first.split("-").map(String::toInt)
            val (secondStart, secondEnd) = second.split("-").map(String::toInt)
            val firstAsRange = IntRange(firstStart, firstEnd)
            val secondAsRange = IntRange(secondStart, secondEnd)
            return firstAsRange.contains(secondStart) || firstAsRange.contains(secondEnd) || secondAsRange.contains(firstStart) || secondAsRange.contains(firstEnd)
        }
    }

}
