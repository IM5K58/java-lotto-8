package lotto.model;

public class Constants {
    static final String ERROR = "[ERROR]";
    static final String SEPARATOR = ",";
    static final int SIZE = 6;
    static final int MAX_RANGE = 45;
    static final int MIN_RANGE = 1;
    static final int LOTTO_PRICE = 1000;
    static final String PATTERN = "^[0-9,]+$";
    static final String DUPLICATED_NUMBER_FOUND = ERROR + " 로또 번호에 중복된 숫자가 있습니다.";
    static final String DUPLICATED_NUMBER_FOUND_BETWEEN_BONUS_AND_LOTTO = ERROR + " 보너스 번호와 당첨 번호 사이에 중복된 값이 존재합니다.";
    static final String INVALID_NUMBER = ERROR + " 숫자가 잘못되었습니다.";
    static final String INVALID_BONUS_NUMBER = ERROR + " 보너스 번호가 유효한 범위의 값이 아닙니다.";
    static final String INVALID_CHARACTER_IN_MONEY_INPUT = ERROR + " 입력된 금액에 잘못된 문자가 포합되었습니다.";
    static final String AT_LEAST_ONE_LOTTO_WARNING = ERROR + " 로또를 최소 1회 뽑을 수 있는 돈을 입력해야합니다.";
    static final String MUST_DIVIDED_WITH_UNIT = ERROR + " 1000으로 나누어 떨어질 수 있는 돈을 입력해야합니다.";
    static final String MUST_SATISFY_SIZE = ERROR + " 로또 번호는 " + SIZE + "개여야 합니다.";
    static final String WRONG_NUMBER_INPUT = ERROR + " 잘못된 당첨 번호가 입력되었습니다.";

}
