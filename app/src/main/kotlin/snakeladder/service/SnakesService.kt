package snakeladder.service

import snakeladder.models.Board
import snakeladder.models.Position
import snakeladder.models.Snake

open class SnakesService(
    private val board: Board
) {
    private fun isThereASnakeIn(currentPosition: Position): Snake? {
        board.getSnakes().forEach {
            if (it.startPosition == currentPosition) {
                println("Oops... A Snake")
                return it
            }
        }
        return null
    }

    fun positionAfterCheckingForSnakeBite(currentPosition: Position): Position? {
        val snake = isThereASnakeIn(currentPosition)
        if (snake != null)
            return snake.endPosition

        return null
    }
}