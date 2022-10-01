package snakeladder.service

import io.kotest.assertions.timing.eventually
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
    private val playersService = mockk<PlayersService>()

    private val movementService = MovementService(laddersService, snakesService, skipsService, playersService)

    init {
        "should increase the player position by the number in dice when checkForSkip returns false" {
            val rolledValue = 1
            val player = Player(
                1,
                "playerOne",
                Position(5)
            )

            val pseudoPosition = Position(player.position.value + rolledValue)

            every {
                skipsService.checkForSkip(player)
            } returns false

            every {
                playersService.isEligibleToMove(pseudoPosition)
            } returns true

            every {
                snakesService.positionAfterCheckingForSnakeBite(pseudoPosition)
            } returns null

            every {
                laddersService.positionAfterCheckingForLadderClimb(pseudoPosition)
            } returns null

            movementService.makeMove(player, rolledValue)

            player.position shouldBe Position(6)
        }

        "should not increase the player position by the number in dice when checkForSkip returns true" {
            val rolledValue = 1
            val player = Player(
                1,
                "playerOne",
                Position(5)
            )

            val pseudoPosition = Position(player.position.value + rolledValue)

            every {
                skipsService.checkForSkip(player)
            } returns true

            movementService.makeMove(player, rolledValue)

            player.position shouldBe Position(5)
        }

        "should set the player position to the endPosition of snake if a snake is encountered" {
            val rolledValue = 1
            val player = Player(
                1,
                "playerOne",
                Position(5)
            )

            val pseudoPosition = Position(player.position.value + rolledValue)

            every {
                skipsService.checkForSkip(player)
            } returns false

            every {
                playersService.isEligibleToMove(pseudoPosition)
            } returns true

            every {
                laddersService.positionAfterCheckingForLadderClimb(pseudoPosition)
            } returns null

            every {
                snakesService.positionAfterCheckingForSnakeBite(pseudoPosition)
            } returns Position(1)

            movementService.makeMove(player, rolledValue)

            player.position shouldBe Position(1)
        }

        "should set the player position to the endPosition of ladder if a ladder is encountered" {
            val rolledValue = 1
            val player = Player(
                1,
                "playerOne",
                Position(5)
            )

            val pseudoPosition = Position(player.position.value + rolledValue)

            every {
                skipsService.checkForSkip(player)
            } returns false

            every {
                playersService.isEligibleToMove(pseudoPosition)
            } returns true

            every {
                laddersService.positionAfterCheckingForLadderClimb(pseudoPosition)
            } returns Position(90)

            every {
                snakesService.positionAfterCheckingForSnakeBite(pseudoPosition)
            } returns null

            movementService.makeMove(player, rolledValue)

            player.position shouldBe Position(90)
        }
    }

}