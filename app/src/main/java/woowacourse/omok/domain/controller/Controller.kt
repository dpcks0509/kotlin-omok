package woowacourse.omok.domain.controller

import woowacourse.omok.domain.model.BlackTurn
import woowacourse.omok.domain.model.Board
import woowacourse.omok.domain.model.FinishedTurn
import woowacourse.omok.domain.model.Point
import woowacourse.omok.domain.model.RuleAdapter
import woowacourse.omok.domain.model.Turn
import woowacourse.omok.domain.view.InputView
import woowacourse.omok.domain.view.OutputView

class Controller {
    fun play() {
        gameStart(Board(15))
    }

    private fun gameStart(board: Board) {
        OutputView.printGameStart()
        OutputView.printBoard(board)
        val ruleAdapter = RuleAdapter(board)
        var turn: Turn = BlackTurn()
        while (turn !is FinishedTurn) {
            OutputView.printTurn(turn, board.beforePoint)
            turn = board.putStone(readPoint(board, turn), turn, ruleAdapter)
            OutputView.printBoard(board)
        }
        OutputView.printTurn(turn, board.beforePoint)
    }

    private fun readPoint(
        board: Board,
        turn: Turn,
    ): Point {
        runCatching {
            return InputView.readPoint(board)
        }.onFailure {
            OutputView.printInvalidPointInputMessage()
            OutputView.printTurn(turn, board.beforePoint)
        }
        return readPoint(board, turn)
    }
}