package lotto.model

import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class WinnerLottoTest {
    @DisplayName(value = "보너스 숫자가 기존 로또 번호와 중복되는 숫자인지 확인한다.")
    @Test
    fun validLottoCheck() {
        assertThatThrownBy {
            WinnerLotto(
                Lotto.make("1,2,3,4,5,10"), LottoNo.from(1)
            )
        }.isInstanceOf(IllegalArgumentException::class.java)
    }
}