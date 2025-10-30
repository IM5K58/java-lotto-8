package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoCountTest {

    @Test
    @DisplayName("돈을 1000원 미만으로 입력하면 오류가 발생한다.")
    void 천원_미만_테스트(){
        assertThatThrownBy(() -> new LottoCount(999))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("돈을 음수로 입력하면 오류가 발생한다.")
    void 음수_테스트(){
        assertThatThrownBy(() -> new LottoCount(-29))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("돈을 1000원 단위로 입력하지 않으면 오류가 발생한다.")
    void 단위_테스트(){
        assertThatThrownBy(() -> new LottoCount(2550))
                .isInstanceOf(IllegalArgumentException.class);
    }
}