package snakeladder.models

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.ints.shouldBeInRange

class DiceTest: StringSpec() {
    init {
        "rolled dice number should be between 1 and 6" {
            val dice = Dice()
            val rolledNumber = dice.rollTheDice()

            rolledNumber shouldBeInRange 1..6
        }
    }
}