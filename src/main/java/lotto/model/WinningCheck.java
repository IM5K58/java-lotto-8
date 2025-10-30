package lotto.model;


public class WinningCheck {
    Lotto winningNumber;
    int bonusNumber;


    public WinningCheck(Lotto lotto, int number){
        this.winningNumber = lotto;
        this.bonusNumber = number;
    }

    public long calculateTotalPrize(Lottos lottos){
        long totalPrize = 0L;
        for(Lotto lotto : lottos.getLottos()){
            int matchCount = lotto.matchCount(this.winningNumber);
            boolean bonusMatch = lotto.matchBonus(this.bonusNumber);

            WinningRank rank = WinningRank.findRank(matchCount, bonusMatch);
            totalPrize += rank.getPrizeMoney();
        }
        return totalPrize;
    }

    private boolean bonusCheck(int num){
        if(num != bonusNumber){
            return false;
        }
        return true;
    }
}
