package snakeladder.models

import snakeladder.constants.Constants
import java.util.Random

class Dice() {
    fun rollTheDice(): Int {
        val rolledValue =
            Random().nextInt(Constants.MAX_DICE_VALUE - Constants.MIN_DICE_VALUE + 1) + Constants.MIN_DICE_VALUE
        printRolledValue(rolledValue)
        return rolledValue
    }

    private fun printRolledValue(rolledValue: Int) {
        println("You rolled $rolledValue in the dice")
    }
}