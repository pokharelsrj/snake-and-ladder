package snakeladder.service

import snakeladder.models.Ladder
import snakeladder.models.Position
import java.util.ArrayList

class LaddersService(
    private val ladders:ArrayList<Ladder>
) {


    private fun isThereASnakeIn(currentPosition: Position): Ladder? {
        ladders.forEach {
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