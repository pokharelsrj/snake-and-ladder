package snakeladder.models

class Board constructor(
    private val boardDimension: Int
) {
    private val snakes = ArrayList<Snake>()
    private val ladders = ArrayList<Ladder>()
    private val skips = ArrayList<Skip>()
    fun getBoardSize(): Int {
        return boardDimension * boardDimension
    }

    fun setSnakes(snake: Snake): Unit {
        snakes.add(snake)
    }

    fun setLadders(ladder: Ladder): Unit {
        ladders.add(ladder)
    }

    fun setSkips(skip: Skip): Unit {
        skips.add(skip)
    }

    fun getSnakes(): ArrayList<Snake> {
        return snakes;
    }

    fun getLadders(): ArrayList<Ladder> {
        return ladders;
    }

    fun getSkips(): ArrayList<Skip> {
        return skips;
    }
}