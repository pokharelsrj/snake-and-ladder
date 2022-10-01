package snakeladder.service

import snakeladder.models.Board
import snakeladder.models.Player

class SkipsService(
    private val board: Board
) {
    private val skipMap = HashMap<Player, Int>()
    fun checkForSkip(player: Player): Boolean {
        board.getSkips().forEach {
            if (it.position == player.position) {
                return performSkipOperation(player)
            }
        }
        return false
    }

    private fun performSkipOperation(player: Player): Boolean {
        println("Oops... You will have to skip your turn")
        if (skipMap.containsKey(player))
            return decreaseSkipCount(player)
        else
            setSkipInitially(player)
        return true
    }

    private fun decreaseSkipCount(player: Player): Boolean {
        val skipsLeft = skipMap[player]
        if (skipsLeft == 0) {
            skipMap.remove(player)
            return false
        } else
            if (skipsLeft != null) {
                skipMap[player] = skipsLeft - 1
            }
        return true
    }

    private fun setSkipInitially(player: Player) {
        skipMap[player] = 3
    }

}