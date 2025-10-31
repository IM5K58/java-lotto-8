package lotto.model;

import java.util.Map;
import java.util.EnumMap;

public class WinningCheck {
    Lotto winningNumber;
    int bonusNumber;


    public WinningCheck(Lotto lotto, int number){
        this.winningNumber = lotto;
        this.bonusNumber = number;
    }

    public long calculateTotalPrize(Map<WinningRank, Integer> winningTimes){
        long totalPrize = 0L;
        for(Map.Entry<WinningRank, Integer> entry : winningTimes.entrySet()){
            WinningRank winningRank = entry.getKey();
            int count = entry.getValue();

            totalPrize += (long)winningRank.getPrizeMoney() * count;
        }
        return totalPrize;
    }

    public Map<WinningRank, Integer> getWinningTimes(Lottos lottos) {
        Map<WinningRank, Integer> winningTimes = new EnumMap<>(WinningRank.class);

        countWinnings(lottos, winningTimes);
        return winningTimes;
    }

    private void countWinnings(Lottos lottos, Map<WinningRank, Integer> winningTimes) {
        for (WinningRank rank : WinningRank.values()) {
            winningTimes.put(rank, 0);
        }
        for (Lotto lotto : lottos.getLottos()) {
            int matchCount = lotto.matchCount(this.winningNumber);
            boolean bonusMatch = lotto.matchBonus(this.bonusNumber);
            WinningRank rank = WinningRank.findRank(matchCount, bonusMatch); //

            winningTimes.put(rank, winningTimes.get(rank) + 1);
        }
    }
}
