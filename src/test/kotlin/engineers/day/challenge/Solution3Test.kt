package engineers.day.challenge

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class Solution3Test {

  @ParameterizedTest
  @CsvSource(
    value = [
      "'', NO",
      "aaBabcDaA, B",
      "Codility, NO",
      "aaBabcdDaA, D",
      "WeTestCodErs, T"
    ]
  )
  fun test(S: String, solution: String) {
    assertThat(solution(S)).isEqualTo(solution)
  }

  fun solution(S: String): String {
    val count = mutableMapOf<Char,Pair<Boolean, Boolean>>()
    S.forEach {
      val current = count[it.lowercaseChar()] ?: false to false
      count[it.lowercaseChar()] = (current.first || it.isLowerCase()) to (current.second || it.isUpperCase())
    }
    val filter = count.entries.filter { it.value.first && it.value.second }
    return if (filter.isEmpty()) "NO" else filter.maxOf { it.key }.uppercase()
  }
}
