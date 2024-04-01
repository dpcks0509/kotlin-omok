package woowacourse.omok.domain.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class BoardTest {
    private lateinit var board: Board
    private lateinit var ruleAdapter: RuleAdapter

    @BeforeEach
    fun setUp() {
        board = Board(15)
        ruleAdapter = RuleAdapter(board)
    }

    @Test
    fun `보드에 돌 착수 확인`() {
        board.putStone(Point(3, 8), BlackTurn(), ruleAdapter)

        assertThat(board.getBoardPoint(Point(3, 8)) == StoneType.BLACK).isTrue
    }
}
