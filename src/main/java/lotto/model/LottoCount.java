package lotto.model;

public class LottoCount {
    private final int lottoCounts;

    public LottoCount(int money){
        Validator validator = new Validator();
        validator.validateMoney(money);
        this.lottoCounts = money/Constants.LOTTO_PRICE;
    }

    public int getLottoCounts() {
        return lottoCounts;
    }

}
