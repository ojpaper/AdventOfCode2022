package src.main.java.com.github.ojpaper.day03;

import java.util.Set;
import java.util.stream.Collectors;

public class Rucksack {

    private Set<Character> first;
    private Set<Character> second;

    public Rucksack(String input) {
        int half = input.length()/2;
        String firstPart = input.substring(0, half);
        String secondPart = input.substring(half);
        first = firstPart.chars().mapToObj(c -> (char) c).collect(Collectors.toSet());
        second = secondPart.chars().mapToObj(c -> (char) c).collect(Collectors.toSet());
    }

    private Character findCommonChar() {
        first.retainAll(second);
        return first.iterator().next();
    }

    private int getCharacterValue(char common) {
        int value = (int) common;
        if(value > 96) {
            //a-z
            return value - 96;
        } else {
            //A-Z
            return value - 64 + 26;
        }
    }

    public int getPriority() {
        return getCharacterValue(findCommonChar());
    }
}
