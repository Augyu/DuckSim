package ducksim

import java.awt.Color

class RubberDuck : Duck() {

    override val color: Color = Color.YELLOW
    override val quackText: String = "Squeak!"

    override fun fly() {
        // do nothing
    }

    override fun display() = "Rubber"
}