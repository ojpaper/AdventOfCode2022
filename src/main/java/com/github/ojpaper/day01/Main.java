package src.main.java.com.github.ojpaper.day01;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collector;

public class Main {

    private static final String INPUT_NAME = "src/main/resources/01.txt";

    public static void main(String[] args) throws Exception {
        Set<Elf> elves = new LinkedHashSet<>();
        Elf currentElf = new Elf(); // might have one more elf if first line is empty
        for(String line : Files.readAllLines(Paths.get(INPUT_NAME))) {
            if(line.isBlank()) {
                elves.add(currentElf);
                currentElf = new Elf();
            } else {
                try {
                    Long snack = Long.valueOf(line);
                    currentElf.addSnack(snack);
                } catch (NumberFormatException e) {
                    // Ignore?
                }
            }
        }
        System.out.print("Most calories: ");
        System.out.println(elves.stream().max(Comparator.comparing(Elf::getSumSnacks)).map(Elf::getSumSnacks).orElse(0L));
        
        List<Elf> sortedElves = new LinkedList<>(elves);
        Collections.sort(sortedElves, Collections.reverseOrder(Comparator.comparing(Elf::getSumSnacks)));

        System.out.print("Sum top 3 calories: ");
        System.out.println(sortedElves.stream().limit(3).map(Elf::getSumSnacks).reduce(Long::sum).orElse(0L));
        
    }

}