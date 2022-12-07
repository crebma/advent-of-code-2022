package rucksack

import rucksack.InventoryDuplicateTotaler.Companion.total
import java.nio.file.Files
import kotlin.io.path.Path
import kotlin.test.Test
import kotlin.test.assertEquals

internal class InventoryDuplicateTotalerTest {
    @Test
    fun totalsOneRucksack() {
        val total = total("vJrwpWtwJgWrhcsFMMfFFhFp")
        assertEquals(16, total)
    }

    @Test
    fun totalsSixRucksack() {
        val total =
            total("vJrwpWtwJgWrhcsFMMfFFhFp\n" + "jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL\n" + "PmmdzqPrVvPwwTWBwg\n" + "wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn\n" + "ttgJtRGJQctTZtZT\n" + "CrZsJsPPZsGzwwsLwLmpwMDw")
        assertEquals(157, total)
    }

    @Test
    fun totalsAllRucksack() {
        val input = Files.readAllLines(
            Path("src/test/resources/rucksacks.txt")
        ).joinToString("\n")
        val total = total(input)
        assertEquals(7990, total)
    }
}
