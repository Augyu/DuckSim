package ducksim

import java.awt.Color

abstract class Duck {

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

    // function for setting the state back to its default (swimming)

    fun swim() {
        state = State.SWIMMING
    }

    // functions from the context menu

    open fun fly() {
        state = State.FLYING
    }

    open fun quack() {
        state = State.QUACKING
    }

    val joinDSCW = object: DuckMenuItem {
        override fun invoke() {
            isOnDSWC = true
        }
    }

    val quitDSCW = object: DuckMenuItem {
        override fun invoke() {
            isOnDSWC = false
        }
    }

    val capture = object: DuckMenuItem {
        override fun invoke() {
            isFree = false
        }
    }

    val release = object: DuckMenuItem {
        override fun invoke() {
            isFree = true
        }
    }

    // abstract display function that must be implemented by concrete classes

    abstract fun display(): String
}
