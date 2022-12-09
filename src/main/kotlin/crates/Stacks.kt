package crates

class Stacks(stacksText: String) {

    val all: List<Stack> = parseStacks(stacksText)

    private fun parseStacks(stacksText: String): List<Stack> {
        val allRows = readStacks(stacksText)
        val parsedStacks = parseRow(allRows.first()).map(::stack)
        allRows
            .drop(1)
            .map(::parseRow)
            .forEach { row ->
                row.forEachIndexed { index, crate ->
                    val stack = parsedStacks.first { stack -> stack.number == index + 1 }
                    if (crate.isNotBlank()) {
                        stack.crates.add(crate[1])
                    }
                }
            }
        return parsedStacks
    }

    private fun readStacks(stacksText: String) = stacksText
        .split("\n")
        .filter { segment -> segment.isNotBlank() }
        .reversed()

    private fun stack(stackText: String) = Stack(
        stackText
            .trim()
            .toInt()
    )

    private fun parseRow(row: String) = row
        .chunked(4)
}
