package cleanup

import cleanup.OverlapTotaler.Companion.totalOverlaps
import java.nio.file.Files
import kotlin.io.path.Path
import kotlin.test.Test
import kotlin.test.assertEquals

internal class OverlapTotalerTest {

    @Test
    fun findsOverlapInOnePairOfAssignments() {
        val overlapTotal = totalOverlaps("52-76,61-67")
        assertEquals(1, overlapTotal)
    }

    @Test
    fun findsOverlapInSixPairOfAssignments() {
        val overlapTotal = totalOverlaps("2-4,6-8\n" + "2-3,4-5\n" + "5-7,7-9\n" + "2-8,3-7\n" + "6-6,4-6\n" + "2-6,4-8")
        assertEquals(2, overlapTotal)
    }

    @Test
    fun findsOverlapInActualAssignments() {
        val input = Files.readAllLines(
            Path("src/test/resources/cleanupAssignments.txt")
        ).joinToString("\n")
        val overlapTotal = totalOverlaps(input)
        assertEquals(503, overlapTotal)
    }

}
