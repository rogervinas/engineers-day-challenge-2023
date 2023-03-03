package engineers.day.challenge

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class Solution1Test {

  @ParameterizedTest
  @CsvSource(
    value = [
      "'', 0",
      "^vv<v, 2",
      "v>>>vv, 3",
      "<<<, 0",
    ]
  )
  fun test(S: String, solution: Int) {
    assertThat(solution(S)).isEqualTo(solution)
  }

  fun solution(S: String): Int {
    return if (S.isEmpty()) {
      0
    } else {
      val count = mutableMapOf<Char, Int>()
      S.forEach {
        count[it] = (count[it] ?: 0) + 1
      }
      S.length - count.entries.maxOf { it.value }
    }
  }
}
