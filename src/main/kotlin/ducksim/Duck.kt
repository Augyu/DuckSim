package ducksim

import java.awt.Color

abstract class Duck(
    private val defaultFlyBehavior: FlyBehavior = FlyWithWings(),
    private val defaultQuackBehavior: QuackBehavior = QuackNormal(null)
) : Observer {

    // values that can be overridden

    open val color: Color = Color.BLACK
    open var quackText: String = defaultQuackBehavior.getQuack()

    // variables that can be changed only by functions in this class

    var state = State.SWIMMING
        private set
    var isFree = true
        private set
    var isOnDSWC = false
        private set
    var flyBehavior: FlyBehavior = defaultFlyBehavior
        private set
    var quackBehavior: QuackBehavior = defaultQuackBehavior

    // function for setting the state back to its default (swimming)
    var welcomeText = "Welcome"

    fun swim() {
        state = State.SWIMMING
    }

    // functions from the context menu

    open fun fly() {
        state = flyBehavior.state
    }

    open fun quack() {
        state = if (isFree) State.QUACKING else State.SWIMMING
    }

    fun welcome() {
        state = State.WELCOMING
        welcomeText = if (isFree) "Welcome" else "Beware!"
    }

    val joinDSCW = object : DuckMenuItem {
        override fun invoke() {
            isOnDSWC = true
            DuckFactory.registerObserver(this@Duck)
        }
    }

    val quitDSCW = object : DuckMenuItem {
        override fun invoke() {
            isOnDSWC = false
            DuckFactory.removeObserver(this@Duck)
        }
    }

    val capture = object : DuckMenuItem {
        override fun invoke() {
            isFree = false
            flyBehavior = FlyNoWay()
            quackBehavior = QuackNoWay()
            quackText = quackBehavior.getQuack()
        }
    }

    val release = object : DuckMenuItem {
        override fun invoke() {
            isFree = true
            flyBehavior = defaultFlyBehavior
            quackBehavior = defaultQuackBehavior
            quackText = quackBehavior.getQuack()
        }
    }

    // abstract display function that must be implemented by concrete classes

    abstract fun display(): String

    override fun update() {
        welcome()
    }
}
