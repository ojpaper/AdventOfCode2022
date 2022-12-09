package src.main.java.com.github.ojpaper.day04;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class Main {
    

    private static final String INPUT_NAME = "src/main/resources/04.txt";

    public static void main(String[] args) throws Exception {
        long count1 = 0;
        long count2 = 0;
        for(String line : Files.readAllLines(Paths.get(INPUT_NAME))) {
            int[] numbers = Arrays.stream(line.split("[-,]")).mapToInt(Integer::parseInt).toArray();
            if((numbers[0] - numbers[2]) * (numbers[1] - numbers[3]) <= 0){
                count1++;
            }
            if(numbers[0] <= numbers[3] && numbers[2] <= numbers[1]) {
                count2++;
            }
        }
        System.out.print("Round 1: ");
        System.out.println(count1);
        System.out.print("Round 2: ");
        System.out.println(count2);
    }
}

