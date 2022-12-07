package rucksack

import rucksack.InventoryPriorityTotaler.Companion.totalDuplicates
import rucksack.InventoryPriorityTotaler.Companion.totalGroups
import java.nio.file.Files
import kotlin.io.path.Path
import kotlin.test.Test
import kotlin.test.assertEquals

internal class InventoryPriorityTotalerTest {
    @Test
    fun totalsDuplicatesInOneRucksack() {
        val total = totalDuplicates("vJrwpWtwJgWrhcsFMMfFFhFp")
        assertEquals(16, total)
    }

    @Test
    fun totalsDuplicatesInSixRucksack() {
        val total =
            totalDuplicates("vJrwpWtwJgWrhcsFMMfFFhFp\n" + "jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL\n" + "PmmdzqPrVvPwwTWBwg\n" + "wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn\n" + "ttgJtRGJQctTZtZT\n" + "CrZsJsPPZsGzwwsLwLmpwMDw")
        assertEquals(157, total)
    }

    @Test
    fun totalsDuplicatesInAllRucksacks() {
        val input = Files.readAllLines(
            Path("src/test/resources/rucksacks.txt")
        ).joinToString("\n")
        val total = totalDuplicates(input)
        assertEquals(7990, total)
    }

    @Test
    fun totalsGroupsInThreeRucksacks() {
        val total = totalGroups("vJrwpWtwJgWrhcsFMMfFFhFp\n" + "jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL\n" + "PmmdzqPrVvPwwTWBwg")
        assertEquals(18, total)
    }

    @Test
    fun totalsGroupsInSixRucksack() {
        val total =
            totalGroups("vJrwpWtwJgWrhcsFMMfFFhFp\n" + "jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL\n" + "PmmdzqPrVvPwwTWBwg\n" + "wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn\n" + "ttgJtRGJQctTZtZT\n" + "CrZsJsPPZsGzwwsLwLmpwMDw")
        assertEquals(70, total)
    }

    @Test
    fun totalsGroupsInAllRucksacks() {
        val input = Files.readAllLines(
            Path("src/test/resources/rucksacks.txt")
        ).joinToString("\n")
        val total = totalGroups(input)
        assertEquals(2602, total)
    }
}
