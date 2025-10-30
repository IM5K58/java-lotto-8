package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class LottoGenerator {

    static final int MIN_NUM = 1;
    static final int MAX_NUM = 45;
    static final int PICK_COUNTS = 6;
    public List<Integer> generateLottoNumber(){
        return Randoms.pickUniqueNumbersInRange(MIN_NUM,MAX_NUM,PICK_COUNTS);
    }


}
