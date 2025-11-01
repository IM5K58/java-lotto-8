package lotto.dto;

public class RankResultDTO {

    private final int matchCount;
    private final long prizeMoney;
    private final boolean isBonus;
    private final int count;

    public RankResultDTO(int matchCount, long prizeMoney, boolean isBonus, int count) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
        this.isBonus = isBonus;
        this.count = count;
    }
    
    public int getMatchCount() {
        return matchCount;
    }

    public long getPrizeMoney() {
        return prizeMoney;
    }

    public boolean isBonus() {
        return isBonus;
    }

    public int getCount() {
        return count;
    }
}
