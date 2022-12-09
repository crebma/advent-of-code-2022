package crates

import java.nio.file.Files
import kotlin.io.path.Path
import kotlin.test.Test
import kotlin.test.assertEquals

internal class StacksTest {
    @Test
    fun canReadEmptyStack() {
        val stacksText = " 1\n"
        val stacks = Stacks(stacksText)
        assertEquals(1, stacks.all.size)
        val stack = stacks.all[0]
        assertEquals(1, stack.number)
        assertEquals(0, stack.crates.size)
    }

    @Test
    fun canReadTwoEmptyStacks() {
        val stacksText = " 1  2\n"
        val stacks = Stacks(stacksText)
        assertEquals(2, stacks.all.size)
        val firstStack = stacks.all[0]
        val secondStack = stacks.all[1]
        assertEquals(1, firstStack.number)
        assertEquals(0, firstStack.crates.size)
        assertEquals(2, secondStack.number)
        assertEquals(0, firstStack.crates.size)
    }

    @Test
    fun canReadOneStackWithOneCrate() {
        val stacksText = "[A]\n 1\n"
        val stack = Stacks(stacksText).all[0]
        assertEquals(1, stack.crates.size)
        assertEquals('A', stack.crates[0])
    }

    @Test
    fun canReadTwoStacksWithTwoCrates() {
        val stacksText = "[C] [D]\n[A] [B]\n 1   2\n"
        val stacks = Stacks(stacksText)
        val firstStack = stacks.all[0]
        val secondStack = stacks.all[1]
        assertEquals(2, firstStack.crates.size)
        assertEquals('A', firstStack.crates[0])
        assertEquals('C', firstStack.crates[1])
        assertEquals(2, secondStack.crates.size)
        assertEquals('B', secondStack.crates[0])
        assertEquals('D', secondStack.crates[1])
    }

    @Test
    fun canReadTheActualStacks() {
        val stacksText = Files
            .readAllLines(
            Path("src/test/resources/crates.txt")
        ).joinToString("\n")
        val stacks = Stacks(stacksText)
        assertEquals(9, stacks.all.size)
        assertEquals(listOf('L', 'N', 'W', 'T', 'D'), stacks.all[0].crates)
        assertEquals(listOf('C', 'P', 'H'), stacks.all[1].crates)
        assertEquals(listOf('W', 'P', 'H', 'N', 'D', 'G', 'M', 'J'), stacks.all[2].crates)
        assertEquals(listOf('C', 'W', 'S', 'N', 'T', 'Q', 'L'), stacks.all[3].crates)
        assertEquals(listOf('P', 'H', 'C', 'N'), stacks.all[4].crates)
        assertEquals(listOf('T', 'H', 'N', 'D', 'M', 'W', 'Q', 'B'), stacks.all[5].crates)
        assertEquals(listOf('M', 'B', 'R', 'J', 'G', 'S', 'L'), stacks.all[6].crates)
        assertEquals(listOf('Z', 'N', 'W', 'G', 'V', 'B', 'R', 'T'), stacks.all[7].crates)
        assertEquals(listOf('W', 'G', 'D', 'N', 'P', 'L'), stacks.all[8].crates)
    }
}
