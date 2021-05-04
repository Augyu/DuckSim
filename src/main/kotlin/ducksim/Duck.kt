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
    open var flyBehavior: FlyBehavior = defaultFlyBehavior

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
        state = if (isFree && quackBehavior !is QuackNoWay) State.QUACKING else State.SWIMMING
    }

    fun welcome() {
        state = State.WELCOMING
        welcomeText = if (isFree) "Welcome" else "Beware!"
    }

    open val joinDSCW = object : DuckMenuItem {
        override fun invoke() {
            doJoinDSCW()
        }
    }

    fun doJoinDSCW() {
        isOnDSWC = true
        DuckFactory.registerObserver(this@Duck)
    }

    open val quitDSCW = object : DuckMenuItem {
        override fun invoke() {
            doQuitDSWC()
        }
    }

    fun doQuitDSWC() {
        isOnDSWC = false
        DuckFactory.removeObserver(this@Duck)
    }

    open val capture = object : DuckMenuItem {
        override fun invoke() {
            doCapture()
        }
    }

    fun doCapture() {
        isFree = false
        flyBehavior = FlyNoWay()
        quackBehavior = QuackNoWay()
        quackText = quackBehavior.getQuack()
    }

    open val release = object : DuckMenuItem {
        override fun invoke() {
            doRelease()
        }
    }

    fun doRelease() {
        isFree = true
        flyBehavior = defaultFlyBehavior
        quackBehavior = defaultQuackBehavior
        quackText = quackBehavior.getQuack()
    }

    // abstract display function that must be implemented by concrete classes

    abstract fun display(): String

    override fun update() {
        welcome()
    }
}
