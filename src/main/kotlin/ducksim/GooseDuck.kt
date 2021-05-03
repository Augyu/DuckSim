package ducksim

import java.awt.Color

class GooseDuck : Duck(FlyWithWings(), QuackNormal(Goose().honkText)) {

    override val color: Color = Color.BLUE

    override fun display(): String {
        return Goose().name
    }

}