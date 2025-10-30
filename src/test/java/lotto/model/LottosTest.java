package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LottosTest {

    @Test
    @DisplayName("Lottos의 List에 Lotto가 저장되는지 확인한다.")
    void 저장_확인_테스트(){
        Lottos lottos = new Lottos();
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));

        lottos.addLotto(lotto);
        assertThat(lottos.getSize()).isEqualTo(1);

    }

}