package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {
    public void validateLottoSize(List<Integer> numbers) {
        if (numbers.size() != Constants.SIZE) {
            throw new IllegalArgumentException(Constants.MUST_SATISFY_SIZE);
        }
    }

    public void validateNumberRange(List<Integer> numbers) {
        for(Integer number : numbers){
            if(!(number >= Constants.MIN_RANGE && number <= Constants.MAX_RANGE)){
                throw new IllegalArgumentException(Constants.INVALID_NUMBER);
            }
        }
    }
    public void validateDuplicates(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(Constants.DUPLICATED_NUMBER_FOUND);
        }
    }

    public void validateMoney(int money){
        if(money < Constants.LOTTO_PRICE){
            throw new IllegalArgumentException(Constants.AT_LEAST_ONE_LOTTO_WARNING);
        }
        else if(money % Constants.LOTTO_PRICE != 0){
            throw new IllegalArgumentException(Constants.MUST_DIVIDED_WITH_UNIT);
        }
    }

    public void validateStringInput(String input){
        if(!input.matches(Constants.PATTERN)){
            throw new IllegalArgumentException(Constants.WRONG_NUMBER_INPUT);
        }
    }

    public void validateBonusNumberDuplicates(int bonusNumber,Lotto lotto){
        if(lotto.getLottoNumbers().contains(bonusNumber)){
            throw new IllegalArgumentException(Constants.DUPLICATED_NUMBER_FOUND_BETWEEN_BONUS_AND_LOTTO);
        }
    }

    public void validateBonusNumberRange(int bonusNumber){
        if(!(bonusNumber >= Constants.MIN_RANGE && bonusNumber <= Constants.MAX_RANGE)){
            throw new IllegalArgumentException(Constants.INVALID_BONUS_NUMBER);
        }
    }

    public void validateMoneyContainsCharacter(String money){
        if(!money.matches(Constants.PATTERN)){
            throw new IllegalArgumentException(Constants.INVALID_CHARACTER_IN_MONEY_INPUT);
        }
    }

}
