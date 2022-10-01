package snakeladder.service

import snakeladder.models.Position
import snakeladder.models.Snake

open class SnakesService(
) {
    private var snakes = ArrayList<Snake>()

    fun setSnakes(snakes: ArrayList<Snake>) {
        this.snakes = snakes
    }
    private fun isThereASnakeIn(currentPosition: Position): Snake? {
        snakes.forEach {
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