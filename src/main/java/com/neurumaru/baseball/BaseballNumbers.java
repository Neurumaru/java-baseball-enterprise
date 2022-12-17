package com.neurumaru.baseball;

import java.util.ArrayList;
import java.util.List;

public class BaseballNumbers {
    private static final int MIN_DIGIT = 1;
    private static final int MAX_DIGIT = 9;
    protected static final List<Integer> lookUpTable = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);

    private List<Integer> numbers;

    public BaseballNumbers(int digit) {
        int validatedDigit = cutMinMax(digit, MIN_DIGIT, MAX_DIGIT);
        setRandomNumbers(validatedDigit);
    }

    public BaseballNumbers(List<Integer> numbers) {
        this.numbers = new ArrayList<>(numbers.size());
        this.numbers.addAll(numbers);
    }

    private void setRandomNumbers(int digit) {
        Permutation permutation = new Permutation(9, digit);
        permutation.rand();
        numbers = permutation.map(lookUpTable);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public boolean equals(BaseballNumbers baseballNumbers) {
        return numbers.equals(baseballNumbers.getNumbers());
    }

    public static int cutMinMax(int number, int min, int max) {
        return Math.max(Math.min(number, max), min);
    }
}