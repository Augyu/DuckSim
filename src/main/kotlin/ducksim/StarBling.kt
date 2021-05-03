package ducksim

class StarBling(private val duckArg: Duck): Bling(duckArg) {

    override fun display(): String = duckArg.display() + ":*"

}