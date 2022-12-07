package rucksack

import rucksack.RucksackChecker.Companion.duplicated

class InventoryChecker {
    companion object {
        fun duplicates(inventory: String): List<String> {
            val rucksacks = inventory.split("\n")
            return rucksacks.map(::duplicated)
        }
    }

}
