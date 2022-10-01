package snakeladder.service

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import snakeladder.models.Ladder
import snakeladder.models.Position

class LaddersServiceTest: StringSpec() {
    private val laddersService = LaddersService(
        arrayListOf(
            Ladder(
                Position(2),
                Position(15)
            )
        )
    )

    init {
        "Should return Ladder if ladder is present at a given position" {
            val ladderClimbCheck = laddersService.positionAfterCheckingForLadderClimb(
                Position(2)
            )

            ladderClimbCheck shouldBe Position(15)
        }

        "Should return null if ladder is not present at a given position" {
            val ladderClimbCheck = laddersService.positionAfterCheckingForLadderClimb(
                Position(5)
            )

            ladderClimbCheck shouldBe null
        }
    }
}