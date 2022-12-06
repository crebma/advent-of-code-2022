package calories

import kotlin.test.Test
import kotlin.test.assertEquals

internal class CalorieTotalerTest {

    @Test
    fun canTotalOneLine(): Unit {
        val total = CalorieTotaler().total("1")
        assertEquals(1, total)
    }

    @Test
    fun canTotalADifferentLine(): Unit {
        val total = CalorieTotaler().total("10")
        assertEquals(10, total)
    }

    @Test
    fun canTotalTwoLines(): Unit {
        val total = CalorieTotaler().total("10\n10")
        assertEquals(20, total)
    }

}
