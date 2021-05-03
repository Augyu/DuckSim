package ducksim

object DuckFactory {
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
}