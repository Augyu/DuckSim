package ducksim

class MoonBling(private val duckArg: Duck): Bling(duckArg) {

    override fun display(): String = duckArg.display() + ":)"

}