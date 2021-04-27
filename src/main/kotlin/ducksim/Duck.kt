package ducksim

import java.awt.Color

abstract class Duck(private val defaultFlyBehavior: FlyBehavior = FlyWithWings()) {

    // values that can be overridden

    open val color: Color = Color.BLACK
    open val quackText: String = "Quack!"

    // variables that can be changed only by functions in this class

    var state = State.SWIMMING
        private set
    var isFree = true
        private set
    var isOnDSWC = false
        private set
    var flyBehavior: FlyBehavior = defaultFlyBehavior
        private set
    // function for setting the state back to its default (swimming)

    fun swim() {
        state = State.SWIMMING
    }

    // functions from the context menu

    open fun fly() {
        state = flyBehavior.state
    }

    open fun quack() {
        state = State.QUACKING
    }

    val joinDSCW = object : DuckMenuItem {
        override fun invoke() {
            isOnDSWC = true
        }
    }

    val quitDSCW = object : DuckMenuItem {
        override fun invoke() {
            isOnDSWC = false
        }
    }

    val capture = object : DuckMenuItem {
        override fun invoke() {
            isFree = false
            flyBehavior = FlyNoWay()
        }
    }

    val release = object : DuckMenuItem {
        override fun invoke() {
            isFree = true
            flyBehavior = defaultFlyBehavior
        }
    }

    // abstract display function that must be implemented by concrete classes

    abstract fun display(): String
}
