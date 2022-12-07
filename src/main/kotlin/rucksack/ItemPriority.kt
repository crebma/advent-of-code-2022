package rucksack

class ItemPriority {

    companion object {
        fun priority(item: String): Int {
            return priorities.indexOf(item[0]) + 1
        }

        private val priorities: List<Char> =
            CharRange('a', 'z').toList().plus(CharRange('A', 'Z').toList())
    }

}
