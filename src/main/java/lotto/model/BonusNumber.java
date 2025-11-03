package lotto.model;

import lotto.utils.Parser;

public class BonusNumber {
    private final int bonusNumber;

    public BonusNumber(String bonusNumber,Lotto lotto){
        Validator validator = new Validator();
        Parser parser = new Parser();
        //입력한 보너스 번호에 숫자 이외의 것이 포함됐는지에 대한 검증
        this.bonusNumber = parser.integerParser(bonusNumber);
        validator.validateBonusNumberDuplicates(this.bonusNumber,lotto);
        validator.validateBonusNumberRange(this.bonusNumber);
    }

    public int getBonusNumber(){
        return bonusNumber;
    }
}
