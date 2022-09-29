package snakeladder.service

import snakeladder.models.Board
import snakeladder.models.Player
import snakeladder.models.Position

class MovementService(
    private val laddersService: LaddersService,
    private val snakesService: SnakesService,
    private val skipsService: SkipsService
) {

    private val board = Board(10)
    private val boardSize = board.getBoardSize()

    fun makeMove(
        player: Player,
        rolledValue: Int
    ) {
        if (!skipsService.checkForSkip(player)) {
            val currentPosition = player.position

            val projectedPosition = currentPosition.value + rolledValue

            var pseudoPosition: Position = Position(projectedPosition)
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