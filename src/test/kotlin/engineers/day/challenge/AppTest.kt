package engineers.day.challenge

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class AppTest {

  @Test
  fun appHasAGreeting() {
    assertThat(App().greeting).isEqualTo("Hello World!")
  }
}
