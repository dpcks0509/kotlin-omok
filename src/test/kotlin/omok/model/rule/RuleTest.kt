package omok.model.rule

import omok.model.Board
import omok.model.Point
import omok.model.Stone
import omok.model.StoneType
import omok.rule.BlackRule
import omok.rule.WhiteRule
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class RuleTest {
    private lateinit var board: Board

    @BeforeEach
    fun setUp() {
        board = Board()
    }

    @Test
    fun `블랙 타입의 돌이 가로로 5개 연속되어 있을때 게임 종료`() {
        board.putStone(Point(1, 1))
        board.putStone(Point(14, 1))
        board.putStone(Point(1, 2))
        board.putStone(Point(14, 2))
        board.putStone(Point(1, 3))
        board.putStone(Point(14, 3))
        board.putStone(Point(1, 4))
        board.putStone(Point(14, 4))

        assertThat(BlackRule.isWinCondition(board, Stone(StoneType.BLACK, Point(1, 5)))).isTrue
    }

    @Test
    fun `블랙 타입의 돌은 가로로 6개 이상 연속되어 있다면 게임이 종료되지 않는다 `() {
        board.putStone(Point(1, 1))
        board.putStone(Point(14, 1))
        board.putStone(Point(1, 2))
        board.putStone(Point(14, 2))
        board.putStone(Point(1, 3))
        board.putStone(Point(14, 3))
        board.putStone(Point(1, 4))
        board.putStone(Point(14, 4))
        board.putStone(Point(1, 6))
        board.putStone(Point(13, 1))

        assertThat(BlackRule.isWinCondition(board, Stone(StoneType.BLACK, Point(1, 5)))).isFalse
    }

    @Test
    fun `화이트 타입의 돌은 가로로 6개 이상 연속되어 있어도 게임 종료`() {
        board.putStone(Point(14, 1))
        board.putStone(Point(1, 1))
        board.putStone(Point(14, 2))
        board.putStone(Point(1, 2))
        board.putStone(Point(14, 3))
        board.putStone(Point(1, 3))
        board.putStone(Point(14, 4))
        board.putStone(Point(1, 4))
        board.putStone(Point(13, 1))
        board.putStone(Point(1, 6))

        assertThat(WhiteRule.isWinCondition(board, Stone(StoneType.WHITE, Point(1, 5)))).isTrue
    }

    @Test
    fun `블랙 타입의 돌이 세로로 5개 연속되어 있을때 게임 종료`() {
        board.putStone(Point(1, 1))
        board.putStone(Point(14, 1))
        board.putStone(Point(2, 1))
        board.putStone(Point(14, 2))
        board.putStone(Point(3, 1))
        board.putStone(Point(14, 3))
        board.putStone(Point(4, 1))
        board.putStone(Point(14, 4))

        assertThat(BlackRule.isWinCondition(board, Stone(StoneType.BLACK, Point(5, 1)))).isTrue
    }

    @Test
    fun `블랙 타입의 돌은 세로로 6개 이상 연속되어 있다면 게임이 종료되지 않는다 `() {
        board.putStone(Point(1, 1))
        board.putStone(Point(14, 1))
        board.putStone(Point(2, 1))
        board.putStone(Point(14, 2))
        board.putStone(Point(3, 1))
        board.putStone(Point(14, 3))
        board.putStone(Point(4, 1))
        board.putStone(Point(14, 4))
        board.putStone(Point(6, 1))
        board.putStone(Point(13, 1))

        assertThat(BlackRule.isWinCondition(board, Stone(StoneType.BLACK, Point(1, 5)))).isFalse
    }

    @Test
    fun `화이트 타입의 돌이 세로로 6개 연속되어 있어도 게임 종료`() {
        board.putStone(Point(14, 1))
        board.putStone(Point(1, 1))
        board.putStone(Point(14, 2))
        board.putStone(Point(2, 1))
        board.putStone(Point(14, 3))
        board.putStone(Point(3, 1))
        board.putStone(Point(14, 4))
        board.putStone(Point(4, 1))
        board.putStone(Point(13, 1))
        board.putStone(Point(6, 1))

        assertThat(WhiteRule.isWinCondition(board, Stone(StoneType.WHITE, Point(5, 1)))).isTrue
    }

    @Test
    fun `블랙 타입의 돌이 우상향 대각선으로 5개 연속되어 있을때 게임 종료`() {
        board.putStone(Point(1, 1))
        board.putStone(Point(14, 1))
        board.putStone(Point(2, 2))
        board.putStone(Point(14, 2))
        board.putStone(Point(3, 3))
        board.putStone(Point(14, 3))
        board.putStone(Point(4, 4))
        board.putStone(Point(14, 4))

        assertThat(BlackRule.isWinCondition(board, Stone(StoneType.BLACK, Point(5, 5)))).isTrue
    }

    @Test
    fun `블랙 타입의 돌은 우상향 대각선으로 6개 이상 연속되어 있다면 게임이 종료되지 않는다 `() {
        board.putStone(Point(1, 1))
        board.putStone(Point(14, 1))
        board.putStone(Point(2, 2))
        board.putStone(Point(14, 2))
        board.putStone(Point(3, 3))
        board.putStone(Point(14, 3))
        board.putStone(Point(4, 4))
        board.putStone(Point(14, 4))
        board.putStone(Point(6, 6))
        board.putStone(Point(13, 1))

        assertThat(BlackRule.isWinCondition(board, Stone(StoneType.BLACK, Point(5, 5)))).isFalse
    }

    @Test
    fun `화이트 타입의 돌이 우상향 대각선으로 6개 연속되어 있어도 게임 종료`() {
        board.putStone(Point(14, 1))
        board.putStone(Point(1, 1))
        board.putStone(Point(14, 2))
        board.putStone(Point(2, 2))
        board.putStone(Point(14, 3))
        board.putStone(Point(3, 3))
        board.putStone(Point(14, 4))
        board.putStone(Point(4, 4))
        board.putStone(Point(13, 1))
        board.putStone(Point(6, 6))

        assertThat(WhiteRule.isWinCondition(board, Stone(StoneType.WHITE, Point(5, 5)))).isTrue
    }

    @Test
    fun `블랙 타입의 돌이 우하향 대각선으로 5개 연속되어 있을때 게임 종료`() {
        board.putStone(Point(5, 5))
        board.putStone(Point(14, 1))
        board.putStone(Point(6, 4))
        board.putStone(Point(14, 2))
        board.putStone(Point(7, 3))
        board.putStone(Point(14, 3))
        board.putStone(Point(8, 2))
        board.putStone(Point(14, 4))

        assertThat(BlackRule.isWinCondition(board, Stone(StoneType.BLACK, Point(9, 1)))).isTrue
    }

    @Test
    fun `블랙 타입의 돌은 우하향 대각선으로 6개 이상 연속되어 있다면 게임이 종료되지 않는다 `() {
        board.putStone(Point(5, 5))
        board.putStone(Point(14, 1))
        board.putStone(Point(6, 4))
        board.putStone(Point(14, 2))
        board.putStone(Point(7, 3))
        board.putStone(Point(14, 3))
        board.putStone(Point(8, 2))
        board.putStone(Point(14, 4))
        board.putStone(Point(10, 0))
        board.putStone(Point(13, 1))

        assertThat(BlackRule.isWinCondition(board, Stone(StoneType.BLACK, Point(9, 1)))).isFalse
    }

    @Test
    fun `화이트 타입의 돌이 우하향 대각선으로 6개 연속되어 있어도 게임 종료`() {
        board.putStone(Point(14, 1))
        board.putStone(Point(5, 5))
        board.putStone(Point(14, 2))
        board.putStone(Point(6, 4))
        board.putStone(Point(14, 3))
        board.putStone(Point(7, 3))
        board.putStone(Point(14, 4))
        board.putStone(Point(8, 2))
        board.putStone(Point(13, 1))
        board.putStone(Point(10, 0))

        assertThat(WhiteRule.isWinCondition(board, Stone(StoneType.WHITE, Point(9, 1)))).isTrue
    }
}
