package lotto.model;

import java.util.List;
import java.util.stream.Collectors;

public class Parser {
    public List<Integer> integerParser(List<String> sep_value){
        return sep_value
                .stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public int integerParser(String number){
        return Integer.parseInt(number);
    }

}
