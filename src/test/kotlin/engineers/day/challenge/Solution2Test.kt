package engineers.day.challenge

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Solution2Test {

  @Test
  fun test1() {
    assertThat(
      solution(
        intArrayOf(4, 1, 2, 3)
      )
    ).isEqualTo(6)
  }

  @Test
  fun test2() {
    assertThat(
      solution(
        intArrayOf(1, 2, 3, 3, 2, 1, 5)
      )
    ).isEqualTo(7)
  }

  @Test
  fun test3() {
    assertThat(
      solution(
        intArrayOf(1000000000, 1, 2, 2, 1000000000)
      )
    ).isEqualTo(999999999)
  }

  @Test
  fun test4() {
    assertThat(
      solution(
        intArrayOf(1000000000, 1, 1000000000, 1, 1000000000)
      )
    ).isEqualTo(999999998)
  }

  fun solution(A: IntArray): Int {
    return if (A.isEmpty()) 0 else (max(A, 0).value() % 1000000000).toInt()
  }

  data class Entropy(
    val pos: Long,
    val neg: Long
  ) {
    fun value() = pos - neg
    fun max(e: Entropy) = if (e.value() > this.value()) e else this
    fun min(e: Entropy) = if (e.value() < this.value()) e else this
    fun concat(value: Int) = Entropy(this.neg + value, this.pos)

    override fun toString() = "$pos-$neg=${value()}"
  }

  private fun max(A: IntArray, from: Int): Entropy {
    val e = if (from == A.size) {
      Entropy(0, 0)
    } else {
      val e1 = min(A, from + 1).concat(A[from])
      val e2 = max(A, from + 1)
      e1.max(e2)
    }
    return e
  }

  private fun min(A: IntArray, from: Int): Entropy {
    val e = if (from == A.size) {
      Entropy(0, 0)
    } else {
      val e1 = max(A, from + 1).concat(A[from])
      val e2 = min(A, from + 1)
      e1.min(e2)
    }
    return e
  }
}

