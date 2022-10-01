package snakeladder.models

import snakeladder.constants.Constants

class Player(
    val id: Int,
    val name: String,
    var position: Position = Position(0)
) {
    fun printCurrentPosition(): Unit {
        println("Your current position is " + Constants.ANSI_BLUE + "${position.value}" + Constants.ANSI_RESET)
    }

    fun printHomeMessage(): Unit {
        println(Constants.ANSI_RED + "Congratulations! You reached home." + Constants.ANSI_RESET)
    }
}
