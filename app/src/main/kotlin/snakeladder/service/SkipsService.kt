package snakeladder.service

import snakeladder.constants.Constants
import snakeladder.models.Player
import snakeladder.models.Skip

class SkipsService(
) {
    private var skips = ArrayList<Skip>()
    private val skipMap = HashMap<Player, Int>()

    fun setSkips(skips: ArrayList<Skip>) {
        this.skips = skips
    }

    fun checkForSkip(player: Player): Boolean {
        skips.forEach {
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
        skipMap[player] = Constants.NUMBER_OF_TURNS_TO_BE_SKIPPED
    }

}