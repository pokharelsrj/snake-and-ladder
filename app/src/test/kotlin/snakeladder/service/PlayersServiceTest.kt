package snakeladder.service

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk
import snakeladder.models.Board
import snakeladder.models.Player
import snakeladder.models.Position
import java.util.LinkedList
import java.util.Queue

class PlayersServiceTest : StringSpec() {
    private val board = mockk<Board>()

    private val playersService = PlayersService(board)
    private val playerQueue: Queue<Player> = LinkedList()


    init {
        val playerOne = Player(
            1,
            "playerOne",
            Position(50)
        )
        playerQueue.add(
            playerOne
        )
        playersService.setPlayers(
            playerQueue
        )

        "should return true if the player is eligible to move" {
            every {
                board.getBoardSize()
            } returns 100

            val isEligibleToMove = playersService.isEligibleToMove(playerQueue.poll().position)

            isEligibleToMove shouldBe true
        }

        "should return false if the player is not eligible to move" {
            every {
                board.getBoardSize()
            } returns 40

            val isEligibleToMove = playersService.isEligibleToMove(playerQueue.poll().position)

            isEligibleToMove shouldBe false
        }

        "should return the number of remaining players" {
            val numberOfPlayers = playersService.getRemainingPlayers()

            numberOfPlayers shouldBe 1
        }

        "should return current player" {
            val currentPlayer = playersService.getRemainingPlayers()

            currentPlayer shouldBe Player(
                1,
                "playerOne",
                Position(50)
            )
        }

        "should return true if player position  is equal to board size" {
            every {
                board.getBoardSize()
            } returns 50

            val isPlayerHome = playersService.isPlayerHome(
                playerOne
            )

            isPlayerHome shouldBe true
        }

        "should return true if player position is not equal to board size" {
            every {
                board.getBoardSize()
            } returns 60

            val isPlayerHome = playersService.isPlayerHome(
                playerOne
            )

            isPlayerHome shouldBe false
        }
    }
}