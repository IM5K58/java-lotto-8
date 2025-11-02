package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {
    static final String AT_LEAST_ONE_LOTTO_WARNING = "[ERROR] 로또를 최소 1회 뽑을 수 있는 돈을 입력해야합니다.";
    static final String MUST_DIVIDED_WITH_UNIT = "[ERROR] 1000으로 나누어 떨어질 수 있는 돈을 입력해야합니다.";

    public void validateLottoSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    public void validateNumberRange(List<Integer> numbers) {
        for(Integer number : numbers){
            if(!(number > 0 && number < 46)){
                throw new IllegalArgumentException("[Error] 숫자가 잘못되었습니다.");
            }
        }
    }
    public void validateDuplicates(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호에 중복된 숫자가 있습니다.");
        }
    }

    public void validateMoney(int money){
        if(money < 1000){
            throw new IllegalArgumentException(AT_LEAST_ONE_LOTTO_WARNING);
        }
        else if(money % 1000 != 0){
            throw new IllegalArgumentException(MUST_DIVIDED_WITH_UNIT);
        }
    }

    public void validateStringInput(String input){
        String pattern = "^[0-9,]+$";
        if(!input.matches(pattern)){
            throw new IllegalArgumentException("[Error] 잘못된 당첨 번호가 입력되었습니다.");
        }
    }

    public void validateBonusNumber(int bonusNumber,Lotto lotto){
        if(lotto.getLottoNumbers().contains(bonusNumber)){
            throw new IllegalArgumentException("[Error] 보너스 번호와 당첨 번호 사이에 중복된 값이 존재합니다.");
        }
    }
}
