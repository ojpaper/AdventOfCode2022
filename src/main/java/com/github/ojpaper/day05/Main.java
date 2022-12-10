package src.main.java.com.github.ojpaper.day05;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Main {
    

    private static final String INPUT_NAME = "src/main/resources/05.txt";

    public static void main(String[] args) throws Exception {
        List<Stack<Character>> stacks = new ArrayList<>();
        List<Stack<Character>> stacks2 = new ArrayList<>();
        BufferedReader reader = Files.newBufferedReader(Paths.get(INPUT_NAME));
        String line = reader.readLine();
        while(stacks.size() * 4 < line.length() + 1) {
            stacks.add(new Stack<>());
            stacks2.add(new Stack<>());
        }
        for(;line.charAt(1) != '1'; line = reader.readLine()) {
            for(int i = 0; i < stacks.size(); i++) {
                Character crate = line.charAt(i * 4 + 1);
                if(crate != ' ') {
                    stacks.get(i).add(0, crate);
                    stacks2.get(i).add(0, crate);
                }
            }
        }
        Stack<Character> buffer = new Stack<>();
        for(line = reader.readLine(); line != null; line = reader.readLine()) {
            if(!line.isBlank()) {
                String[] move = line.split("\s");
                int amount = Integer.parseInt(move[1]);
                Stack<Character> from = stacks.get(Integer.parseInt(move[3]) - 1);
                Stack<Character> to = stacks.get(Integer.parseInt(move[5]) - 1);
                Stack<Character> from2 = stacks2.get(Integer.parseInt(move[3]) - 1);
                Stack<Character> to2 = stacks2.get(Integer.parseInt(move[5]) - 1);
                for(int i = amount; i != 0; i--) {
                    to.push(from.pop());
                    buffer.add(from2.pop());
                }
                while(!buffer.isEmpty()) {
                    to2.push(buffer.pop());
                }
            }
        }
        String solution = "";
        String solution2 = "";
        for(int i = 0; i < stacks.size(); i++) {
            System.out.println(stacks2.get(i));
            System.out.println(stacks.get(i));
            solution += stacks.get(i).pop();
            solution2 += stacks2.get(i).pop();
        }
        System.out.print("Round 1: ");
        System.out.println(solution);
        System.out.print("Round 2: ");
        System.out.println(solution2);
    }
}

