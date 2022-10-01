package snakeladder.models

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class BoardTest : StringSpec() {
    private val boardDimension = 10
    private val board = Board(boardDimension)

    init {
        "should return the total possible units in the board" {
            val boardSize = board.getBoardSize()

            boardSize shouldBe 100
        }
    }
}