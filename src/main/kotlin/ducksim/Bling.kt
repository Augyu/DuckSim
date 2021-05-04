package ducksim

import java.awt.Color

abstract class Bling(val duck: Duck, val defaultFlyBehavior: FlyBehavior, val defaultQuackBehavior: QuackBehavior) :
    Duck(defaultFlyBehavior, defaultQuackBehavior) {

    override val color: Color
        get() = duck.color

}