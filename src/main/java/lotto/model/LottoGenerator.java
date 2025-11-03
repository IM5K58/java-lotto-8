package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class LottoGenerator {

    public List<Integer> generateLottoNumber(){
        return Randoms.pickUniqueNumbersInRange(Constants.MIN_RANGE,Constants.MAX_RANGE,Constants.SIZE);
    }

}
