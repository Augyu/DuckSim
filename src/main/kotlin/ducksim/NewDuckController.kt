package ducksim

class NewDuckController(val duckPond: DuckPond, val view: DuckSimView) {
    fun createNewDuck() {

        if (duckPond.noSelectedDucks()) {
            val makeDuckDialog = MakeDuckDialog(duckPond, view)
            makeDuckDialog.setSize(300, 200)
            makeDuckDialog.isVisible = true
        } else {
            var ducks = duckPond.selectedDucks.toList()
            ducks = ducks.filterNot { it is Flock }
            if (ducks.size <= 1) return
            // get the selected ducks from the model
            // filter the selected ducks by removing any flocks
            // if there is more than one duck after removing flocks,
            // create a new flock with the selected ducks
            val flock = Flock(ducks)
            duckPond.addNewDuck(flock)
            view.repaint()
        }
    }
}