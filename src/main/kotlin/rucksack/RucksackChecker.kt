package rucksack

import java.util.Objects.requireNonNullElse

class RucksackChecker {
    companion object {
        fun duplicated(input: String): String {
            val rucksack = input.trim().toList()
            if (rucksack.isEmpty()) { return "" }
            return findDuplicate(rucksack)
        }

        private fun findDuplicate(rucksack: List<Char>): String {
            val (firstCompartment, secondCompartment) = compartments(rucksack)
            val duplicateItem = firstCompartment.firstOrNull { item ->
                secondCompartment.contains(item)
            }
            return requireNonNullElse(duplicateItem, "").toString()
        }

        private fun compartments(rucksack: List<Char>): Pair<List<Char>, List<Char>> {
            val half = rucksack.size / 2
            return Pair(rucksack.take(half), rucksack.takeLast(half))
        }
    }

}
