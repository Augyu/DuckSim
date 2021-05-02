package ducksim

import java.awt.Color

abstract class Bling(val duck: Duck): Duck() {

    override val color: Color
        get() = duck.color
    init {
        var resultDuck: Duck = MallardDuck()
        resultDuck = StarBling(resultDuck)
    }
}