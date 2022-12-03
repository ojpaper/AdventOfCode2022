package src.main.java.com.github.ojpaper.day03;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Group {

    private Set<Character> first;
    private Set<Character> second;
    private Set<Character> third;

    public Group(String first, String second, String third) {
        this.first = first.chars().mapToObj(c -> (char) c).collect(Collectors.toSet());
        this.second = second.chars().mapToObj(c -> (char) c).collect(Collectors.toSet());
        this.third = third.chars().mapToObj(c -> (char) c).collect(Collectors.toSet());
    }

    private Character findCommonChar() {
        second.retainAll(third);
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
    
    public static class GroupBuilder {

        List<String> inputs;
        Collection<Group> collection;

        public GroupBuilder(Collection<Group> collection) {
            this.collection = collection;
            inputs = new LinkedList<>();
        }

        public void add(String input) {
            inputs.add(input);
            if(inputs.size() == 3) {
                collection.add(new Group(inputs.get(0), inputs.get(1), inputs.get(2)));
                inputs.clear();
            }
        }
    }
}

