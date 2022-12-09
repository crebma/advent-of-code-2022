package crates

import kotlin.test.Test
import kotlin.test.assertEquals

internal class RearrangementProcedureTest {
    @Test
    fun canReadAProcedureLine() {
        val procedure = RearrangementProcedure("move 1 from 2 to 1")
        assertEquals(1, procedure.quantity)
        assertEquals(2, procedure.from)
        assertEquals(1, procedure.to)
    }

    @Test
    fun canReadAnotherProcedureLine() {
        val procedure = RearrangementProcedure("move 16 from 12 to 8")
        assertEquals(16, procedure.quantity)
        assertEquals(12, procedure.from)
        assertEquals(8, procedure.to)
    }
}
