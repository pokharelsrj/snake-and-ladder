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


    fun beginGame() {
        setBoardItems()
        setPlayers()

        val gameSession = GameSession(players, ladders, skips, snakes)

        gameSession.start()
    }

    private fun setBoardItems() {
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

        ladders.add(
            Ladder(
                Position(12),
                Position(100)
            )
        )

        skips.add(
            Skip(
                Position(6)
            )
        )
    }

    private fun setPlayers() {
        players.add(
            Player(1)
        )

        players.add(
            Player(2)
        )
    }
}