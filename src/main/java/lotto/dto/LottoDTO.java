package lotto.dto;

import java.util.List;

public class LottoDTO {

    private final List<Integer> lottoDTO;

    public LottoDTO(List<Integer> lotto) {
        this.lottoDTO = lotto;
    }

    public List<Integer> getLottoDTO() {
        return this.lottoDTO;
    }
}
