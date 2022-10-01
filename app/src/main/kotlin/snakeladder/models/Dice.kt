package snakeladder.models

import java.util.Random

class Dice() {
    private val MIN_DICE_VALUE = 1
    private val MAX_DICE_VALUE = 6

    fun rollTheDice(): Int {
        val rolledValue = Random().nextInt(MAX_DICE_VALUE - MIN_DICE_VALUE + 1) + MIN_DICE_VALUE
        printRolledValue(rolledValue)
        return rolledValue
    }

    private fun printRolledValue(rolledValue: Int) {
        println("You rolled $rolledValue in the dice")
    }
}