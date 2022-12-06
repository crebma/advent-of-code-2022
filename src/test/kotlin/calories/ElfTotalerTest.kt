package calories

import kotlin.test.Test
import kotlin.test.assertEquals

internal class ElfTotalerTest {

    @Test
    fun canTotalOneElf(): Unit {
        val totals = ElfTotaler().totals("1");
        assertEquals(listOf(1), totals)
    }

    @Test
    fun canTotalTwoElves(): Unit {
        val totals = ElfTotaler().totals("1\n\n10");
        assertEquals(listOf(1, 10), totals)
    }
}
