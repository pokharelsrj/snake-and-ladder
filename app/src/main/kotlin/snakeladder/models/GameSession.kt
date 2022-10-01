package snakeladder.models

import snakeladder.constants.Constants
import snakeladder.service.InputValidator
import snakeladder.service.LaddersService
import snakeladder.service.MovementService
import snakeladder.service.PlayersService
import snakeladder.service.SkipsService
import snakeladder.service.SnakesService
import java.util.*
import kotlin.collections.ArrayList

class GameSession(
    private val players: Queue<Player>,
    private val ladders: ArrayList<Ladder>,
    private val skips: ArrayList<Skip>,
    private val snakes: ArrayList<Snake>,

    ) {
    private val scanner = Scanner(System.`in`)
    private val board = Board(Constants.BOARD_DIMENSION)
    private val playersService = PlayersService(board)
    private val laddersService = LaddersService()
    private val snakesService = SnakesService()
    private val skipsService = SkipsService()
    private val dice = Dice()

    private val movementService = MovementService(laddersService, snakesService, skipsService, playersService)

    fun start() {
        setItemValues()

        while (playersService.getRemainingPlayers() > Constants.MINIMUM_NUMBER_OF_PLAYER_BEFORE_GAME_ENDS) {

            val currentPlayer = playersService.getCurrentPlayer()

            val userInput: Char = scanner.nextLine().toCharArray()[0]

            val rolledValue = dice.rollTheDice()

            if (InputValidator().isValid(userInput))
                movementService.makeMove(currentPlayer, rolledValue)

            if (playersService.isPlayerHome(currentPlayer))
                currentPlayer.printHomeMessage()
            else
                playersService.addCurrentPlayerToQueue(currentPlayer)
        }
    }

    private fun setItemValues() {
        laddersService.setLadders(ladders)
        snakesService.setSnakes(snakes)
        skipsService.setSkips(skips)
        playersService.setPlayers(players)
    }
}