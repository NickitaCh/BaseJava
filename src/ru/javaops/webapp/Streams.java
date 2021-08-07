package ru.javaops.webapp;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.partitioningBy;
import static java.util.stream.Collectors.toList;

public class Streams {
    public static void main(String[] args) {
        System.out.println(minValue(new int[]{1, 2, 5, 3, 1, 2}));

        System.out.println(oddOrEven(Arrays.asList(5, 7, 3, 2, 4)));
        System.out.println(oddOrEven(Arrays.asList(3, 4, 5)));
    }

    public static int minValue(int[] values) {
        int number = Arrays.stream(values).distinct().sorted()
                .reduce(0, (a, b) -> 10 * a + b);
        return number;
    }

    public static List<Integer> oddOrEven(List<Integer> integers) {
        Map<Boolean, List<Integer>> map = integers.stream()
                .collect(partitioningBy(x -> x % 2 == 0, toList()));
        return map.get(map.get(false).size() % 2 != 0);
    }
}
