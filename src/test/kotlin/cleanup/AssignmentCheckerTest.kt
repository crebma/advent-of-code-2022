package cleanup

import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

internal class AssignmentCheckerTest {
    @Test
    fun tellsIfThereAreNoOverlaps() {
        val overlaps = AssignmentChecker.overlaps("2-4,6-8")
        assertFalse(overlaps)
    }

    @Test
    fun notAnOverlapIfNotCompletelyOverlapping() {
        val overlaps = AssignmentChecker.overlaps("5-7,7-9")
        assertFalse(overlaps)
    }

    @Test
    fun isAnOverlapIfFirstCompletelyContainsSecond() {
        val overlaps = AssignmentChecker.overlaps("5-7,5-7")
        assertTrue(overlaps)
    }

    @Test
    fun isAnOverlapIfSecondCompletelyContainsFirst() {
        val overlaps = AssignmentChecker.overlaps("6-6,4-6")
        assertTrue(overlaps)
    }

    @Test
    fun tellsIfThereAreNoOverlapsWithLargeNumbers() {
        val overlaps = AssignmentChecker.overlaps("2-4,26-24")
        assertFalse(overlaps)
    }

    @Test
    fun notAnOverlapIfNotCompletelyOverlappingWithLargeNumbers() {
        val overlaps = AssignmentChecker.overlaps("54-78,74-96")
        assertFalse(overlaps)
    }

    @Test
    fun isAnOverlapIfCompletelyOverlappingWithLargerNumbers() {
        val overlaps = AssignmentChecker.overlaps("22-76,12-77")
        assertTrue(overlaps)
    }
}
