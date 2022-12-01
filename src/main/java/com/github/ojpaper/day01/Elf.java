package src.main.java.com.github.ojpaper.day01;

import java.util.LinkedList;
import java.util.List;

public class Elf {
    
    private List<Long> snacks;

    public Elf() {
        snacks = new LinkedList<>();
    }

    public void addSnack(Long snack) {
        snacks.add(snack);
    }

    public Long getSumSnacks() {
        return snacks.stream().reduce(Long::sum).orElse(0L);
    }
}
