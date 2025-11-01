package lotto.dto;

import java.util.List;

public class LottosDTO {
    private final List<LottoDTO> lottos;

    public LottosDTO(List<LottoDTO> lottos) {
        this.lottos = lottos;
    }

    public List<LottoDTO> getLottos() {
        return lottos;
    }
}