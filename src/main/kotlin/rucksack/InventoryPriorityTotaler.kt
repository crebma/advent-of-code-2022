package rucksack

import rucksack.InventoryChecker.Companion.commonItems
import rucksack.InventoryChecker.Companion.duplicates
import rucksack.ItemPriority.Companion.priority

class InventoryPriorityTotaler {
    companion object {
        fun totalDuplicates(inventory: String): Int {
            return duplicates(inventory).sumOf(::priority)
        }

        fun totalGroups(inventory: String): Int {
            return commonItems(inventory).sumOf(::priority)
        }
    }

}
