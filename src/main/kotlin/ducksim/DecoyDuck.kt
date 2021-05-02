package ducksim

import java.awt.Color

class DecoyDuck : Duck() {

    override val color: Color = Color.ORANGE

    override fun display() = "Decoy"
}
