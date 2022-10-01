package snakeladder.service

import snakeladder.models.Board
import snakeladder.models.Player
import snakeladder.models.Position

class MovementService(
    board: Board
) {

    private val laddersService = LaddersService(board)
    private val snakesService = SnakesService(board)
    private val skipsService = SkipsService(board)
    private val boardSize = board.getBoardSize()

    fun makeMove(
        player: Player,
        rolledValue: Int
    ) {
        if (!skipsService.checkForSkip(player)) {
            val currentPosition = player.position

            val projectedPosition = currentPosition.value + rolledValue

            var pseudoPosition = Position(projectedPosition)
            println("You reached to the position $projectedPosition")

            if (projectedPosition < boardSize) {

                val positionAfterSnakeBite =
                    snakesService.positionAfterCheckingForSnakeBite(Position(projectedPosition))
                if (positionAfterSnakeBite != null)
                    pseudoPosition = positionAfterSnakeBite

                val positionAfterLadderClimb =
                    laddersService.positionAfterCheckingForLadderClimb(Position(projectedPosition))
                if (positionAfterLadderClimb != null)
                    pseudoPosition = positionAfterLadderClimb

                player.position = pseudoPosition
            } else {
                println("You have to try again")
            }
        }
    }
}