package snakeladder.service

import snakeladder.constants.Constants
import snakeladder.models.Board
import snakeladder.models.Player
import snakeladder.models.Position
import java.util.*

class PlayersService(
    private val board: Board
) {
    private var players: Queue<Player> = LinkedList()

    fun isPlayerHome(player: Player): Boolean {
        return player.position.value == board.getBoardSize()
    }

    fun isEligibleToMove(currentPosition: Position): Boolean {
        return currentPosition.value <= board.getBoardSize()
    }

    fun getRemainingPlayers(): Int = players.size

    fun setPlayers(players: Queue<Player>) {
        this.players = players
    }

    fun addCurrentPlayerToQueue(currentPlayer: Player) {
        players.add(currentPlayer)
        currentPlayer.printCurrentPosition()
    }

    fun getCurrentPlayer(): Player {
        val currentPlayer = players.poll()
        println()
        println(Constants.ANSI_GREEN + "${currentPlayer.name}'s " + Constants.ANSI_RESET + "turn to roll the dice. Press any button.")
        return currentPlayer
    }
}