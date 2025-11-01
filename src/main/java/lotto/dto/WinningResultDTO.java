package lotto.dto;

import java.util.List;

public class WinningResultDTO {
    private final List<RankResultDTO> winningResultDTO;

    public WinningResultDTO(List<RankResultDTO> winningResultDTO) {
        this.winningResultDTO = winningResultDTO;
    }
    public List<RankResultDTO> getWinningResultDTO() {
        return winningResultDTO;
    }
}
