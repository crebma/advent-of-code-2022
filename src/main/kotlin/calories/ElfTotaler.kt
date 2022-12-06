package calories

class ElfTotaler {

    fun totals(input: String): List<Int> {
        val elves = input.split("\n\n")
        val calorieTotaler = CalorieTotaler()
        return elves.map { elf -> calorieTotaler.total(elf) }
    }

}
