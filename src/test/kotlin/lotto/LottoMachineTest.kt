package lotto

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe
import lotto.domain.LottoMachine
import lotto.domain.Money
import java.lang.IllegalArgumentException

class LottoMachineTest : FreeSpec({
    "입력된 금앤만큼 로또를 발행한다" {
        val tickets = LottoMachine().buy(Money(14500))
        tickets.size shouldBe 14
    }

    "입력된 금액이 1000원 미만인 경우 에러" {
        val exception = shouldThrow<IllegalArgumentException> {
            LottoMachine().buy(Money(999))
        }
        println(exception.message)
    }
})