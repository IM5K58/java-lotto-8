package lotto.model;

import java.util.Arrays;
import java.util.List;

public class Separator {

    static final String SEPARATOR = ",";
    public List<String> separate(String input){
        try {
            Validator validator = new Validator();
            validator.validateStringInput(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return Arrays.asList(input.split(SEPARATOR));
    }


}
