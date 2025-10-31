package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class WinningCheckTest {

    @Test
    @DisplayName("당첨된 경우를 map에 저장하고, 총 당첨 금액을 계산한다.")
    void 계산_테스트(){
        Lottos lottos = new Lottos();
        Lotto winningNumbers = new Lotto(List.of(1,2,3,4,5,6));
        int bonusNumber = 7;
        WinningCheck winningCheck = new WinningCheck(winningNumbers, bonusNumber);
        lottos.addLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6))); //1등
        lottos.addLotto(new Lotto(List.of(1, 2, 3, 4, 5, 7))); // 2등
        lottos.addLotto(new Lotto(List.of(1, 2, 3, 4, 5, 8))); // 3등
        lottos.addLotto(new Lotto(List.of(1, 2, 3, 4, 8, 10))); // 4등
        lottos.addLotto(new Lotto(List.of(1, 2, 3, 14, 18, 10))); // 5등
        lottos.addLotto(new Lotto(List.of(11, 12, 13, 14, 18, 10))); // Miss

        Map<WinningRank,Integer>winnings = winningCheck.getWinningTimes(lottos);
        long totalPrize = winningCheck.calculateTotalPrize(winnings);

        long predictedPrize = 2_000_000_000 + 30_000_000 + 1_500_000 + 50_000 + 5_000;
        assertThat(totalPrize).isEqualTo(predictedPrize);

    }
}