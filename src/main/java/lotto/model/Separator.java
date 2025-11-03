package lotto.model;

import java.util.Arrays;
import java.util.List;

public class Separator {
    private static final String SEPARATOR = ",";

    public List<String> separate(String input){
        Validator validator = new Validator();
        validator.validateStringInput(input);
        return Arrays.asList(input.split(SEPARATOR));
    }

}
