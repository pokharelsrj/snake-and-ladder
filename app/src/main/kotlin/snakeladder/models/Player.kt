package snakeladder.models

class Player(
    val playerId: Int,
    var position: Position = Position(0)
) {
    fun printCurrentPosition(): Unit {
        println("Your current position is ${position.value}")
    }

    fun printHomeMessage(): Unit {
        println("Congratulations! You reached home.")
    }
}
