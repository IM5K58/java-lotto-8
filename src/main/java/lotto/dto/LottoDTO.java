package lotto.dto;

import lotto.model.Lotto;

import java.util.List;

public class LottoDTO {

    Lotto lottoDTO;
    LottoDTO(List<Integer> lotto) {
        this.lottoDTO = new Lotto(lotto);
    }
    //Lottos에서 List Numbers를 LottoDTO로 변경하여 넘겨주도록 설정
    public Lotto getLottoDTO() {
        return this.lottoDTO;
    }
}
