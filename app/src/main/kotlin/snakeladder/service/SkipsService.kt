package snakeladder.service

import snakeladder.models.Player
import snakeladder.models.Skip

class SkipsService(
    private val skips: ArrayList<Skip>
) {
    private val skipMap = HashMap<Player, Int>()
    fun checkForSkip(player: Player): Boolean {
        skips.forEach {
            if (it.position == player.position) {
                println("Oops... You will have to skip your turn")
                if (skipMap.containsKey(player)) {
                    val skipsLeft = skipMap[player]
                    if (skipsLeft == 0) {
                        skipMap.remove(player)
                        return false
                    } else
                        if (skipsLeft != null) {
                            skipMap[player] = skipsLeft - 1
                        }
                } else {
                    skipMap[player] = 3
                }
                return true
            }
        }
        return false
    }

}