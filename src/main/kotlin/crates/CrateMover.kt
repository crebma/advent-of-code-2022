package crates

class CrateMover {
    companion object {
        fun move(stacksText: String, proceduresText: String): List<Char> {
            val procedures = RearrangementProcedures(proceduresText)
            val stacks = Stacks(stacksText)
            procedures.all.forEach { procedure ->
                val fromStack = stacks.all.first { stack -> stack.number == procedure.from }
                val toStack = stacks.all.first { stack -> stack.number == procedure.to }
                for(i in 1..procedure.quantity) {
                    val topCrate = fromStack.crates.removeLast()
                    toStack.crates.add(topCrate)
                }
            }
            return stacks.all.filter{ stack -> stack.crates.isNotEmpty() }.map { stack -> stack.crates.last() }
        }
    }

}
