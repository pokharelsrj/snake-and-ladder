package snakeladder.service

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk
import snakeladder.models.Player
import snakeladder.models.Position

class MovementServiceTest : StringSpec() {
    private val laddersService = mockk<LaddersService>()
    private val snakesService = mockk<SnakesService>()
    private val skipsService = mockk<SkipsService>()

    private val movementService = MovementService(laddersService, snakesService, skipsService)

    init {
        " should set the player position" {
            val player = Player(
                1,
                Position(5)
            )

            movementService.makeMove(player, 2)

            player.position shouldBe Position(
                7
            )
        }
    }

}