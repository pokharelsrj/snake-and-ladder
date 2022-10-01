package snakeladder.service

import snakeladder.models.Player
import snakeladder.models.Position

class MovementService(
    private val laddersService: LaddersService,
    private val snakesService: SnakesService,
    private val skipsService: SkipsService,
    private val playersService: PlayersService
) {
    fun makeMove(
        currentPlayer: Player,
        rolledValue: Int
    ) {
        if (!skipsService.checkForSkip(currentPlayer)) {
            val currentPosition = currentPlayer.position

            val projectedPosition = currentPosition.value + rolledValue

            var pseudoPosition = Position(projectedPosition)
            println("You reached to the position $projectedPosition")

            if (!playersService.isPlayerHome(currentPlayer)) {

                val positionAfterSnakeBite =
                    snakesService.positionAfterCheckingForSnakeBite(Position(projectedPosition))
                if (positionAfterSnakeBite != null)
                    pseudoPosition = positionAfterSnakeBite

                val positionAfterLadderClimb =
                    laddersService.positionAfterCheckingForLadderClimb(Position(projectedPosition))
                if (positionAfterLadderClimb != null)
                    pseudoPosition = positionAfterLadderClimb

                currentPlayer.position = pseudoPosition
            } else {
                println("You have to try again")
            }
        }
    }
}