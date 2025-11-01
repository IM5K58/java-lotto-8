package lotto.model;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
        sort(this.numbers);
    }

    public List<Integer> getLottoNumbers() {
        return Collections.unmodifiableList(numbers);
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

    private void sort(List<Integer> numbers){
        Collections.sort(numbers);
    }



}
