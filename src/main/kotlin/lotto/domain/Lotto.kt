package lotto.domain

class Lottos(
    val list: List<Lotto>
) {

    fun manualCount() = list.filter { it.lottoType == LottoType.MANUAL }.size
    fun autoCount() = list.filter { it.lottoType == LottoType.AUTO }.size

    companion object {
        fun getAutoLottos(number: Int): Lottos {
            return List(number) { Lotto(LottoNumberGenerator.generate(), LottoType.AUTO) }.toLottos()
        }

        fun getManualLottos(numbers: List<List<Int>>): Lottos {
            return numbers.map { Lotto(it.map { number -> number.toLottoNumber() }, LottoType.MANUAL) }.toLottos()
        }
    }
}

class Lotto(
    val numbers: List<LottoNumber>,
    val lottoType: LottoType = LottoType.AUTO
) {

    init {
        require(numbers.size == 6) { "6개의 숫자가 필요합니다." }
        require(numbers.distinct().size == 6) { "중복되지 않은 6개의 숫자가 필요합니다." }
    }
}

fun List<Lotto>.toLottos() = Lottos(this)
