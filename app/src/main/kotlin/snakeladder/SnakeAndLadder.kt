package snakeladder

import snakeladder.constants.Constants
import snakeladder.models.GameSession
import snakeladder.models.Ladder
import snakeladder.models.Player
import snakeladder.models.Position
import snakeladder.models.Skip
import snakeladder.models.Snake
import snakeladder.service.LaddersService
import snakeladder.service.SkipsService
import snakeladder.service.SnakesService
import java.util.*

class SnakeAndLadder {
    private val players: Queue<Player> = LinkedList()
    private val snakes = ArrayList<Snake>()
    private val ladders = ArrayList<Ladder>()
    private val skips = ArrayList<Skip>()
    private val scanner = Scanner(System.`in`)

    fun beginGame() {
        setBoardItems()
        setPlayers()

        val gameSession = GameSession(players, ladders, skips, snakes)

        gameSession.start()
    }

    private fun setBoardItems() {
        snakes.add(
            Snake(
                Position(15),
                Position(5)
            )
        )

        snakes.add(
            Snake(
                Position(35),
                Position(30)
            )
        )

        snakes.add(
            Snake(
                Position(42),
                Position(9)
            )
        )

        snakes.add(
            Snake(
                Position(78),
                Position(52)
            )
        )

        snakes.add(
            Snake(
                Position(97),
                Position(66)
            )
        )

        ladders.add(
            Ladder(
                Position(12),
                Position(25)
            )
        )

        ladders.add(
            Ladder(
                Position(39),
                Position(76)
            )
        )

        ladders.add(
            Ladder(
                Position(69),
                Position(92)
            )
        )

//        skips.add(
//            Skip(
//                Position(6)
//            )
//        )
    }

    private fun setPlayers() {
        println("Enter the number of players")
        val numberOfPlayers = scanner.nextInt()
        for (playerId in 1..numberOfPlayers) {
            println("Please enter the name for player $playerId")
            val playerName = scanner.next()
            players.add(
                Player(
                    playerId,
                    playerName
                )
            )
        }

//        players.add(
//            Player(3)
//        )
//        players.add(
//            Player(4)
//        )
    }
}