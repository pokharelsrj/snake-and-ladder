package snakeladder.models

class Player(
    val playerId: Int,
    var position: Position = Position(0)
) {
    private val boardSize = Board(10).getBoardSize()

    fun isPlayerHome(): Boolean {
        return position.value == boardSize
    }

    fun printCurrentPosition(): Unit {
        println("Your current position is ${position.value}")
    }

    fun printHomeMessage(): Unit {
        println("Congratulations! You reached home.")
    }
}
