package lotto.model;

import lotto.utils.Separator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class SeparatorTest {
    @Test
    @DisplayName("입력받은 문자열에 대해 ','기준으로 나누어 저장한다.")
    void 분리_테스트(){
        Separator separator = new Separator();
        String sep_value = "1,2,3,4,5,6";
        List<String> sep_res = separator.separate(sep_value);

        assertThat(sep_res).containsExactly("1", "2", "3", "4", "5", "6");
    }
}