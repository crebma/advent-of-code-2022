package rucksack

import rucksack.RucksackChecker.Companion.commonItems
import rucksack.RucksackChecker.Companion.duplicated
import kotlin.test.Test
import kotlin.test.assertEquals

internal class RucksackCheckerTest {
    @Test
    fun returnsEmptyStringWithNothing() {
        assertEquals("", duplicated(""))
    }

    @Test
    fun returnsDuplicateInLine() {
        assertEquals("p", duplicated("pp"))
    }

    @Test
    fun doesNotReturnDuplicatesInSameCompartment() {
        assertEquals("", duplicated("ppqq"))
    }

    @Test
    fun findsDuplicateInLongLine() {
        assertEquals("p", duplicated("vJrwpWtwJgWrhcsFMMfFFhFp"))
    }

    @Test
    fun findsCommonItemInThreeRucksacks() {
        val commonItems =
            commonItems(listOf("vJrwpWtwJgWrhcsFMMfFFhFp",
                "jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL", "PmmdzqPrVvPwwTWBwg"))
        assertEquals("r", commonItems)
    }

    @Test
    fun findsCommonItemInThreeOtherRucksacks() {
        val commonItems =
            commonItems(listOf("wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn",
                "ttgJtRGJQctTZtZT", "CrZsJsPPZsGzwwsLwLmpwMDw"))
        assertEquals("Z", commonItems)
    }
}
