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
    private val snakes = ArrayList<Snake>()
    private val ladders = ArrayList<Ladder>()
    private val boardSize = board.getBoardSize()
    private val players: Queue<Player> = LinkedList<Player>()
    private val skips = ArrayList<Skip>()

    private val laddersService = LaddersService(ladders)
    private val snakesService = SnakesService(snakes)
    private val skipsService = SkipsService(skips)
    private val movementService = MovementService(laddersService, snakesService, skipsService)
    private val playerService = PlayersService(players)



    fun start() {
        //Input Configs
        players.add(
            Player(1)
        )

        players.add(
            Player(2)
        )

        skips.add(
            Skip(
                Position(6)
            )
        )

        snakes.add(
            Snake(
                Position(3),
                Position(0)
            )
        )

        snakes.add(
            Snake(
                Position(10),
                Position(6)
            )
        )

//        ladders.add(
//            Ladder(
//                Position(2),
//                Position(15)
//            )
//        )

        ladders.add(
            Ladder(
                Position(12),
                Position(100)
            )
        )
        // Roll the dice

        //Movements


        while (players.size > 1) {
            val rolledValue = 2

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
}