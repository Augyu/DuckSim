package ducksim

class CrossBling(private val duckArg: Duck): Bling(duckArg) {

    override fun display(): String = duckArg.display() + ":+"

}