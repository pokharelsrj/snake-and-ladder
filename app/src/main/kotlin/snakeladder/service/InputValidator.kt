package snakeladder.service

import snakeladder.constants.Constants

class InputValidator {
    fun isValid(inputCharacter: Char): Boolean {
        return inputCharacter == Constants.CHARACTER_TO_ROLL_THE_DICE
    }
}