package rucksack

import rucksack.InventoryChecker.Companion.duplicates
import rucksack.ItemPriority.Companion.priority

class InventoryDuplicateTotaler {
    companion object {
        fun total(inventory: String): Int {
            return duplicates(inventory).sumOf(::priority)
        }
    }

}
