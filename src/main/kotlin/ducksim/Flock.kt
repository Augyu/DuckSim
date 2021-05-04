package ducksim

class Flock(val children: List<Duck>) : Duck(FlyWithWings(), QuackNormal("Noise!")) {

    var flockName = children.joinToString(separator = ":") { it.display().substring(0, 1) }

    override fun display(): String = "Flock:$flockName"

    override val capture = object: DuckMenuItem {
        override fun invoke() {
            children.forEach { it.doCapture() }
            doCapture()
        }
    }

    override val release = object: DuckMenuItem {
        override fun invoke() {
            children.forEach { it.doRelease() }
            doRelease()
        }
    }

    override val joinDSCW = object: DuckMenuItem {
        override fun invoke() {
            children.forEach { it.doJoinDSCW() }
            doJoinDSCW()
        }
    }

    override val quitDSCW = object: DuckMenuItem {
        override fun invoke() {
            children.forEach { it.doQuitDSWC() }
            doQuitDSWC()
        }
    }


}