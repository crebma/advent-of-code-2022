package crates

class CrateMover {
    companion object {
        fun move(stacksText: String, proceduresText: String): String {
            val procedures = RearrangementProcedures(proceduresText)
            val stacks = Stacks(stacksText)
            procedures.all.forEach { procedure ->
                val fromStack = stacks.all.first { stack -> stack.number == procedure.from }
                val toStack = stacks.all.first { stack -> stack.number == procedure.to }
                val topCrates = fromStack.crates.takeLast(procedure.quantity)
                toStack.crates.addAll(topCrates)
                repeat(procedure.quantity) { fromStack.crates.removeLast() }
            }
            return stacks.all
                .filter { stack -> stack.crates.isNotEmpty() }
                .map { stack -> stack.crates.last() }
                .joinToString("")
        }
    }

}
