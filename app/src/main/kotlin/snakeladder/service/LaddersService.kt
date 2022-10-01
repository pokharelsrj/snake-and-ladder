package snakeladder.service

import snakeladder.models.Board
import snakeladder.models.Ladder
import snakeladder.models.Position
import java.util.ArrayList

open class LaddersService(
    private val board: Board
) {

    private fun isThereASnakeIn(currentPosition: Position): Ladder? {
        board.getLadders().forEach {
            if (it.startPosition == currentPosition) {
                println("Yayyy... A Ladder")
                return it
            }
        }
        return null
    }

    fun positionAfterCheckingForLadderClimb(currentPosition: Position): Position? {
        val ladder = isThereASnakeIn(currentPosition)
        if (ladder != null)
            return ladder.endPosition

        return null
    }
}