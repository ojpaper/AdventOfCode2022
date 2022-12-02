package src.main.java.com.github.ojpaper.day02;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;

public class Main {
    

    private static final String INPUT_NAME = "src/main/resources/02.txt";

    public static void main(String[] args) throws Exception {
        Set<Match> matches = new HashSet<>();
        for(String line : Files.readAllLines(Paths.get(INPUT_NAME))) {
            if(!line.isBlank()) {
                String[] match = line.split("\s");
                matches.add(new Match(match[0], match[1]));
            }
        }
        System.out.print("Round 1: ");
        System.out.println(matches.stream().map(Match::getTotalScore).reduce(Long::sum).orElse(0L));
        System.out.print("Round 2: ");
        System.out.println(matches.stream().map(Match::getTotalScore2).reduce(Long::sum).orElse(0L));
    }
}
