package lotto.model;

public class LottoCount {
    private final int lottoCounts;
    static final String AT_LEAST_ONE_LOTTO_WARNING = "[ERROR] 로또를 최소 1회 뽑을 수 있는 돈을 입력해야합니다.";
    static final String MUST_DIVIDED_WITH_UNIT = "[ERROR] 1000으로 나누어 떨어질 수 있는 돈을 입력해야합니다.";

    public LottoCount(int money){
        validate(money);
        this.lottoCounts = money/1000;
    }

    private void validate(int money){
        if(money < 1000){
            throw new IllegalArgumentException(AT_LEAST_ONE_LOTTO_WARNING);
        }
        else if(money % 1000 != 0){
            throw new IllegalArgumentException(MUST_DIVIDED_WITH_UNIT);
        }
    }
}
