package lotto.model;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validate_two(numbers);
        validateDuplicates(numbers);
        this.numbers = numbers;
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

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void validate_two(List<Integer> numbers) {
        for(Integer number : numbers){
            if(!(number > 0 && number < 46)){
                throw new IllegalArgumentException("[Error] 숫자가 잘못되었습니다.");
            }
        }
    }
    private void validateDuplicates(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호에 중복된 숫자가 있습니다.");
        }
    }

    private void sort(List<Integer> numbers){
        Collections.sort(numbers);
    }



}
