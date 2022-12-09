package crates

class RearrangementProcedures(proceduresGuide: String) {

    val all: List<RearrangementProcedure> = proceduresGuide.split("\n").map(::RearrangementProcedure)

}
