package snakeladder.service

import snakeladder.models.Ladder
import snakeladder.models.Position

class LaddersService {
    private var ladders = ArrayList<Ladder>()

    fun setLadders(ladders: ArrayList<Ladder>) {
        this.ladders = ladders
    }

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