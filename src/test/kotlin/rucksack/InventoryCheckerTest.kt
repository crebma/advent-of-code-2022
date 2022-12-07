package rucksack

import rucksack.InventoryChecker.Companion.duplicates
import kotlin.test.Test
import kotlin.test.assertEquals

internal class InventoryCheckerTest {

    @Test
    fun canGiveDuplicatesInOneRucksack() {
        val duplicates = duplicates("vJrwpWtwJgWrhcsFMMfFFhFp")
        assertEquals(listOf("p"), duplicates)
    }

    @Test
    fun canGiveDuplicatesInSixRucksacks() {
        val duplicates =
            duplicates("vJrwpWtwJgWrhcsFMMfFFhFp\n" + "jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL\n" + "PmmdzqPrVvPwwTWBwg\n" + "wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn\n" + "ttgJtRGJQctTZtZT\n" + "CrZsJsPPZsGzwwsLwLmpwMDw")
        assertEquals(listOf("p", "L", "P", "v", "t", "s"), duplicates)
    }

}
