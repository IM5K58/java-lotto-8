package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {
    private static final String PATTERN = "^[0-9,]+$";
    private static final String ERROR = "[ERROR]";
    private static final String DUPLICATED_NUMBER_FOUND = ERROR + " 로또 번호에 중복된 숫자가 있습니다.";
    private static final String DUPLICATED_NUMBER_FOUND_BETWEEN_BONUS_AND_LOTTO = ERROR + " 보너스 번호와 당첨 번호 사이에 중복된 값이 존재합니다.";
    private static final String INVALID_NUMBER = ERROR + " 숫자가 잘못되었습니다.";
    private static final String INVALID_BONUS_NUMBER = ERROR + " 보너스 번호가 유효한 범위의 값이 아닙니다.";
    private static final String INVALID_CHARACTER_IN_MONEY_INPUT = ERROR + " 입력된 금액에 잘못된 문자가 포합되었습니다.";
    private static final String AT_LEAST_ONE_LOTTO_WARNING = ERROR + " 로또를 최소 1회 뽑을 수 있는 돈을 입력해야합니다.";
    private static final String MUST_DIVIDED_WITH_UNIT = ERROR + " 1000으로 나누어 떨어질 수 있는 돈을 입력해야합니다.";
    private static final String MUST_SATISFY_SIZE = ERROR + " 로또 번호는 " + Constants.SIZE + "개여야 합니다.";
    private static final String WRONG_NUMBER_INPUT = ERROR + " 잘못된 당첨 번호가 입력되었습니다.";

    public void validateLottoSize(List<Integer> numbers) {
        if (numbers.size() != Constants.SIZE) {
            throw new IllegalArgumentException(MUST_SATISFY_SIZE);
        }
    }

    public void validateNumberRange(List<Integer> numbers) {
        for(Integer number : numbers){
            if(!(number >= Constants.MIN_RANGE && number <= Constants.MAX_RANGE)){
                throw new IllegalArgumentException(INVALID_NUMBER);
            }
        }
    }
    public void validateDuplicates(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(DUPLICATED_NUMBER_FOUND);
        }
    }

    public void validateMoney(int money){
        if(money < Constants.LOTTO_PRICE){
            throw new IllegalArgumentException(AT_LEAST_ONE_LOTTO_WARNING);
        }
        else if(money % Constants.LOTTO_PRICE != 0){
            throw new IllegalArgumentException(MUST_DIVIDED_WITH_UNIT);
        }
    }

    public void validateStringInput(String input){
        if(!input.matches(PATTERN)){
            throw new IllegalArgumentException(WRONG_NUMBER_INPUT);
        }
    }

    public void validateBonusNumberDuplicates(int bonusNumber,Lotto lotto){
        if(lotto.getLottoNumbers().contains(bonusNumber)){
            throw new IllegalArgumentException(DUPLICATED_NUMBER_FOUND_BETWEEN_BONUS_AND_LOTTO);
        }
    }

    public void validateBonusNumberRange(int bonusNumber){
        if(!(bonusNumber >= Constants.MIN_RANGE && bonusNumber <= Constants.MAX_RANGE)){
            throw new IllegalArgumentException(INVALID_BONUS_NUMBER);
        }
    }

    public void validateMoneyContainsCharacter(String money){
        if(!money.matches(PATTERN)){
            throw new IllegalArgumentException(INVALID_CHARACTER_IN_MONEY_INPUT);
        }
    }

}
