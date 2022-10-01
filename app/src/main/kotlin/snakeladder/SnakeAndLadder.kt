package snakeladder

import snakeladder.models.Board
import snakeladder.models.Dice
import snakeladder.models.Ladder
import snakeladder.models.Player
import snakeladder.models.Position
import snakeladder.models.Skip
import snakeladder.models.Snake
import snakeladder.service.InputValidator
import snakeladder.service.LaddersService
import snakeladder.service.MovementService
import snakeladder.service.PlayersService
import snakeladder.service.SkipsService
import snakeladder.service.SnakesService
import java.util.*

class SnakeAndLadder {
    private val scanner = Scanner(System.`in`)
    private val dice = Dice()
    private val board = Board(10)

    private val players: Queue<Player> = LinkedList()
    private val movementService = MovementService(board)
    private val playerService = PlayersService(players)


    fun start() {
        initializeBoard()
        initializePlayer()

        while (players.size > 1) {
            val rolledValue = dice.rollTheDice()

            val currentPlayer = playerService.getCurrentPlayer()

            val userInput: Char = scanner.nextLine().toCharArray()[0]

            if (InputValidator().isValid(userInput))
                movementService.makeMove(currentPlayer, rolledValue)

            if (currentPlayer.isPlayerHome())
                currentPlayer.printHomeMessage()
            else
                playerService.addCurrentPlayerToQueue(currentPlayer)
        }
    }

    fun initializeBoard() {
        board.setSnakes(
            Snake(
                Position(3),
                Position(0)
            )
        )

        board.setSnakes(
            Snake(
                Position(10),
                Position(6)
            )
        )

        board.setLadders(
            Ladder(
                Position(12),
                Position(100)
            )
        )

        board.setSkips(
            Skip(
                Position(6)
            )
        )
    }

    fun initializePlayer() {
        players.add(
            Player(1)
        )

        players.add(
            Player(2)
        )
    }
}