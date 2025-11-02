package lotto.model;

import java.util.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {

        Validator validator = new Validator();
        validator.validateLottoSize(numbers);
        validator.validateNumberRange(numbers);
        validator.validateDuplicates(numbers);

        this.numbers = new ArrayList<>(numbers);
        sort(this.numbers);
    }

    public List<Integer> getLottoNumbers() {
        return numbers;
    }

    public int matchCount(Lotto otherLotto){
        int matchCount = 0;
        matchCount += (int)this.numbers.stream()
                .filter(number-> otherLotto.getLottoNumbers().contains(number)).count();
        return matchCount;
    }

    public boolean matchBonus(int bonusNum){
        if(numbers.contains(bonusNum)){
            return true;
        }
        return false;
    }

    private void sort(List<Integer> numbers){
        Collections.sort(numbers);
    }



}
