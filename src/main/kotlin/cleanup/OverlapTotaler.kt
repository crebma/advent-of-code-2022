package cleanup

class OverlapTotaler {
    companion object {
        fun totalOverlaps(allAssignments: String): Int {
            val assignments = allAssignments.split("\n")
            return assignments.map { pair -> AssignmentChecker.overlaps(pair) }
                .count { doesOverlap -> doesOverlap }
        }
    }

}
