package ducksim

object DuckFactory : Subject {

    private val observers = mutableListOf<Observer>()

    fun createDuck(baseDuck: Duck, starCount: Int, moonCount: Int, crossCount: Int): Duck {
        var resultDuck: Duck = baseDuck
        repeat(starCount) {
            resultDuck = StarBling(resultDuck, baseDuck.flyBehavior, baseDuck.quackBehavior)
        }
        repeat(moonCount) {
            resultDuck = MoonBling(resultDuck, baseDuck.flyBehavior, baseDuck.quackBehavior)
        }
        repeat(crossCount) {
            resultDuck = CrossBling(resultDuck, baseDuck.flyBehavior, baseDuck.quackBehavior)
        }
        return resultDuck
    }

    override fun registerObserver(observer: Observer) {
        observers.add(observer)
    }

    override fun removeObserver(observer: Observer) {
        observers.remove(observer)
    }

    override fun notifyObservers() {
        observers.forEach { it.update() }
    }
}