package ducksim

import java.awt.Color

class DecoyDuck : Duck() {

    override val color: Color = Color.YELLOW
    override val quackText: String = ""

    override fun fly() {
        // do nothing
    }

    override fun quack() {
        // do nothing
    }

    override fun display() = "Rubber"
}
