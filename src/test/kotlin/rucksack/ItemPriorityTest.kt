package rucksack

import rucksack.ItemPriority.Companion.priority
import kotlin.test.Test
import kotlin.test.assertEquals

internal class ItemPriorityTest {
    @Test
    fun aIs1() {
        assertEquals(1, priority("a"))
    }

    @Test
    fun AIs27() {
        assertEquals(27, priority("A"))
    }

    @Test
    fun zIs26() {
        assertEquals(26, priority("z"))
    }

    @Test
    fun ZIs52() {
        assertEquals(52, priority("Z"))
    }
}
