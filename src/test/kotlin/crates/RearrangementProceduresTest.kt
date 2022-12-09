package crates

import java.nio.file.Files
import kotlin.io.path.Path
import kotlin.test.Test
import kotlin.test.assertEquals

internal class RearrangementProceduresTest {
    @Test
    fun canReadAProcedureLine() {
        val procedures = RearrangementProcedures("move 1 from 2 to 1")
        val procedure = procedures.all[0]
        assertEquals(1, procedure.quantity)
        assertEquals(2, procedure.from)
        assertEquals(1, procedure.to)
    }

    @Test
    fun canReadTwoProcedureLines() {
        val procedures = RearrangementProcedures("move 1 from 2 to 1\nmove 16 from 12 to 8")
        val firstProcedure = procedures.all[0]
        assertEquals(1, firstProcedure.quantity)
        assertEquals(2, firstProcedure.from)
        assertEquals(1, firstProcedure.to)

        val secondProcedure = procedures.all[1]
        assertEquals(16, secondProcedure.quantity)
        assertEquals(12, secondProcedure.from)
        assertEquals(8, secondProcedure.to)
    }

    @Test
    fun canReadActualProcedureLines() {
        val procedureText = Files
            .readAllLines(
                Path("src/test/resources/rearrangementProcedure.txt")
            )
            .joinToString("\n")
        val procedures = RearrangementProcedures(procedureText)
        val firstProcedure = procedures.all[0]
        assertEquals(6, firstProcedure.quantity)
        assertEquals(6, firstProcedure.from)
        assertEquals(5, firstProcedure.to)

        val secondProcedure = procedures.all[1]
        assertEquals(2, secondProcedure.quantity)
        assertEquals(5, secondProcedure.from)
        assertEquals(9, secondProcedure.to)
    }
}
