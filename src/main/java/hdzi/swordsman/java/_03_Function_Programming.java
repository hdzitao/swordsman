package hdzi.swordsman.java;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by taojinhou on 2018/9/5.
 */
public class _03_Function_Programming {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Map<Integer, ?> collect = list.stream()
                .map((x) -> x + 1)
                .collect(Collectors.groupingBy((x) -> x % 3,
                        Collectors.mapping((x) -> x + 10,
                                Collectors.mapping((x) -> x - 20,
                                        Collectors.toList()))));
        System.out.println(collect);

        collect = list.stream()
                .map((x) -> x + 1)
                .collect(Collectors.groupingBy((x) -> x % 3, Collectors.reducing(0, (x, y) -> x + y)));
        System.out.println(collect);
    }
}
