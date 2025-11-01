package lotto.dto;

import lotto.model.Lotto;

import java.util.List;

public class LottoDTO {

    private final List<Integer> lottoDTO;

    LottoDTO(List<Integer> lotto) {
        this.lottoDTO = lotto;
    }
    public List<Integer> getLottoDTO() {
        return this.lottoDTO;
    }
}
