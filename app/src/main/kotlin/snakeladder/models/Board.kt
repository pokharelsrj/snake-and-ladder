package snakeladder.models

class Board constructor(
    private val boardDimension: Int
) {

    fun getBoardSize(): Int {
        return boardDimension * boardDimension
    }
}