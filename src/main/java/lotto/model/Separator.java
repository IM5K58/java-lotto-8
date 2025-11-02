package lotto.model;

import java.util.Arrays;
import java.util.List;

public class Separator {

    static final String SEPARATOR = ",";
    public List<String> separate(String input){
        return Arrays.asList(input.split(SEPARATOR));
    }

}
