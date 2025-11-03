package lotto.model;

import lotto.utils.Parser;

public class Money {
    private int money;
    public Money(String money){
        Validator validator = new Validator();
        Parser moneyParser = new Parser();
        validator.validateMoneyContainsCharacter(money);
        this.money = moneyParser.integerParser(money);
        validator.validateMoney(this.money);
    }

    public int getMoney() {
        return money;
    }

}
