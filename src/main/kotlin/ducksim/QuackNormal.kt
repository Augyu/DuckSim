package ducksim

class QuackNormal(var sound: String?): QuackBehavior {

    override fun getQuack(): String {
        return sound ?: "Quack!"
    }

}