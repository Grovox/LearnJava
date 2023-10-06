package Stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class StreamPrimitiveTypes {
    public static void main(String[] args) {

        // создание потока примитивных стримов
        List<Integer> numbers = new ArrayList<>();
        numbers.stream().mapToInt(value -> value);
        numbers.stream().mapToDouble(value -> value);
        numbers.stream().mapToLong(value -> value);
        // они имеют уникальные методы
        // к примеру диапазон:
        IntStream rangeNumStream = IntStream.range(20,30);
        IntStream rangeClosedNumStream = IntStream.rangeClosed(20, 30);

        System.out.print("IntStream.range(20,30) ->");
        rangeNumStream.forEach(x -> System.out.print(x + " "));
        System.out.println();

        System.out.print("IntStream.rangeClosed(20,30) ->");
        rangeClosedNumStream.forEach(x -> System.out.print(x + " "));
        System.out.println();

    }
}
