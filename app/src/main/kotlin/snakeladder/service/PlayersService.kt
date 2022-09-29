package snakeladder.service

import snakeladder.models.Player
import java.util.*

class PlayersService(
    private val players: Queue<Player>
) {

    fun addCurrentPlayerToQueue(currentPlayer: Player) {
        players.add(currentPlayer)
        currentPlayer.printCurrentPosition()
    }

    fun getCurrentPlayer(): Player {
        val currentPlayer = players.poll()
        println("Player ID: ${currentPlayer.playerId}'s turn to roll the dice. Press any button.")
        return currentPlayer
    }

    fun skipPlayerTurn() {
        val currentPlayer = getCurrentPlayer()
        addCurrentPlayerToQueue(currentPlayer)
    }
}