package _23_behavioral_design_pattern.practice.strategy;

import java.util.List;

public class SelectionSort implements SortStrategy {

    @Override
    public <T> void sort(List<T> items) {
        System.out.println("Selection sort");
    }
}