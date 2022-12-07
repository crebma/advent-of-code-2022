package rucksack

import rucksack.RucksackChecker.Companion.duplicated

class InventoryChecker {
    companion object {
        fun duplicates(inventory: String): List<String> {
            val rucksacks = inventory.split("\n")
            return rucksacks.map(::duplicated)
        }

        fun commonItems(inventory: String): List<String> {
            val rucksacks = inventory.split("\n").chunked(3)
            return rucksacks.map{group -> RucksackChecker.commonItems(group)}
            return listOf("r")
        }
    }

}
