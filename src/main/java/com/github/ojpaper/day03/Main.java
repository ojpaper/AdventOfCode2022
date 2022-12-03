package src.main.java.com.github.ojpaper.day03;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;

import src.main.java.com.github.ojpaper.day03.Group.GroupBuilder;

public class Main {
    

    private static final String INPUT_NAME = "src/main/resources/03.txt";

    public static void main(String[] args) throws Exception {
        Set<Rucksack> sacks = new HashSet<>();
        Set<Group> groups = new HashSet<>();
        GroupBuilder builder = new GroupBuilder(groups);
        for(String line : Files.readAllLines(Paths.get(INPUT_NAME))) {
            sacks.add(new Rucksack(line));
            builder.add(line);
        }
        System.out.print("Round 1: ");
        System.out.println(sacks.stream().map(Rucksack::getPriority).reduce(Integer::sum).orElse(0));
        System.out.print("Round 2: ");
        System.out.println(groups.stream().map(Group::getPriority).reduce(Integer::sum).orElse(0));
    }
}

