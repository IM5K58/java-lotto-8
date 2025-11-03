package lotto.model;

public enum WinningRank {
    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    SECOND(5,30_000_000),
    FIRST(6,2_000_000_000),
    MISS(0, 0);

    private final int matchCount;
    private final int prizeMoney;

    WinningRank(int matchCount, int prizeMoney) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public static WinningRank findRank(int matchCount, boolean bonusMatch) {
        if (matchCount == 6) {
            return FIRST;
        }

        if (matchCount == 5 && bonusMatch) {
            return SECOND;
        }

        if (matchCount == 5) {
            return THIRD;
        }

        if (matchCount == 4) {
            return FOURTH;
        }

        if (matchCount == 3) {
            return FIFTH;
        }

        return MISS;
    }

}
