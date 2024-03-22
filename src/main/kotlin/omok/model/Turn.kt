package omok.model

import omok.rule.BlackRule
import omok.rule.WhiteRule

sealed interface Turn {
    val before: Stone?

    fun putStone(
        point: Point,
        board: Board,
    ): Turn
}

class BlackTurn(override val before: Stone? = null) : Turn {
    override fun putStone(
        point: Point,
        board: Board,
    ): Turn {
        val stone = Stone(StoneType.BLACK, point)
        if (BlackRule.isForbidden(board.board, stone)) return this
        board.putStone(stone)
        if (BlackRule.isWinCondition(board.board, stone)) return FinishedTurn(stone)
        return WhiteTurn(stone)
    }
}

class WhiteTurn(override val before: Stone) : Turn {
    override fun putStone(
        point: Point,
        board: Board,
    ): Turn {
        val stone = Stone(StoneType.WHITE, point)
        board.putStone(stone)
        if (WhiteRule.isWinCondition(board.board, stone)) return FinishedTurn(stone)
        return BlackTurn(stone)
    }
}

class FinishedTurn(override val before: Stone) : Turn {
    override fun putStone(
        point: Point,
        board: Board,
    ): Turn {
        throw IllegalStateException()
    }
}
