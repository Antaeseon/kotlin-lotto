package lotto

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.core.spec.style.BehaviorSpec
import io.mockk.every
import io.mockk.mockkObject
import lotto.domain.LottoMachine
import lotto.domain.input.ConsoleInput
import lotto.domain.strategy.bonus.BonusManualGenerateStrategy
import lotto.domain.strategy.lotto.LottoAutoGenerateStrategy
import lotto.domain.strategy.lotto.LottoManualGenerateStrategy
import lotto.util.Reader

internal class LottoMachineTest : BehaviorSpec({
    Given("로또 머신을 생성하고, ") {
        mockkObject(Reader)
        val money = 2000
        every { Reader.read() }.returnsMany(listOf("1, 2, 3, 4, 5, 6", "1, 2, 3, 4, 5, 6", "7"))
        val lottoMachine = LottoMachine(
            money = money,
            manualTicketCount = 1,
            lottoGenerateStrategies = listOf(LottoAutoGenerateStrategy(), LottoManualGenerateStrategy(ConsoleInput())),
            winnerLottoGenerateStrategy = LottoManualGenerateStrategy(ConsoleInput()),
            bonusGenerateStrategy = BonusManualGenerateStrategy(ConsoleInput()),
        )

        When("수행한다면, ") {
            Then("결과 값을 받아올 수 있다.") {
                shouldNotThrowAny {
                    lottoMachine.execute()
                }
            }
        }
    }
})