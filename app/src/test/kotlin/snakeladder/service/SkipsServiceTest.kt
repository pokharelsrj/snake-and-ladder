package snakeladder.service

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import snakeladder.models.Player
import snakeladder.models.Position
import snakeladder.models.Skip

class SkipsServiceTest: StringSpec() {
    private val skipsService = SkipsService()
    init {
        skipsService.setSkips(
            arrayListOf(
                Skip(
                    Position(2)
                )
            )
        )
        "should return true if a skip is encountered" {
            val player = Player(
                1,
                "playerOne",
                Position(2)
            )
            val checkForSkip = skipsService.checkForSkip(player)

            checkForSkip shouldBe true
        }

        "should return false if a skip is not encountered" {
            val player = Player(
                1,
                "playerOne",
                Position(3)
            )
            val checkForSkip = skipsService.checkForSkip(player)

            checkForSkip shouldBe false
        }
    }
}