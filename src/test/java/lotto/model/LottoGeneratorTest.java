package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class LottoGeneratorTest {

    @Test
    @DisplayName("지정한 범위 내에서 지정한 개수 만큼의 정수를 List로 반환한다.")
    void 로또_번호_생성_테스트(){
        LottoGenerator lottoGenerator = new LottoGenerator();
        List<Integer> res = lottoGenerator.generateLottoNumber();
        System.out.println(res);
    }

}