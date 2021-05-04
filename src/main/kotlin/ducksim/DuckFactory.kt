package ducksim

object DuckFactory : Subject {

    val observers = mutableListOf<Observer>()

    fun createDuck(baseDuck: Duck, starCount: Int, moonCount: Int, crossCount: Int): Duck {
        var resultDuck: Duck = baseDuck
        repeat(starCount) {
            resultDuck = StarBling(resultDuck)
        }
        repeat(moonCount) {
            resultDuck = MoonBling(resultDuck)
        }
        repeat(crossCount) {
            resultDuck = CrossBling(resultDuck)
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