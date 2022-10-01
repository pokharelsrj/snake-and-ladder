package snakeladder.service

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import snakeladder.models.Position
import snakeladder.models.Snake

class SnakesServiceTest : StringSpec() {
    private val snakesService = SnakesService()

    init {
        snakesService.setSnakes(
            arrayListOf(
                Snake(
                    Position(25),
                    Position(4)
                )
            )
        )

        "Should return Snake if snake is present at a given position" {
            val snakeBiteCheck = snakesService.positionAfterCheckingForSnakeBite(
                Position(25)
            )

            snakeBiteCheck shouldBe Position(4)
        }

        "Should return null if snake is not present at a given position" {
            val snakeBiteCheck = snakesService.positionAfterCheckingForSnakeBite(
                Position(12)
            )

            snakeBiteCheck shouldBe null
        }
    }
}