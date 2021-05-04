package ducksim

class CrossBling(
    private val duckArg: Duck,
    private val flyBehaviorArg: FlyBehavior,
    private val quackBehaviorArg: QuackBehavior
) : Bling(duckArg, flyBehaviorArg, quackBehaviorArg) {

    override fun display(): String = duckArg.display() + ":+"

}