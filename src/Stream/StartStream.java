package Stream;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StartStream {
    public static void main(String[] args) {
        // Stream из List
        List<String> list = new ArrayList<>();
        list.stream();
        list.parallelStream(); // паралельны поток

        // Stream из Map
        Map<String, String> map = new HashMap<>();
        map.entrySet().stream();
        map.values().stream();

        // Stream из массива
        String[] array = new String[10];
        Arrays.stream(array);

        // Stream из элементов используя статистический данный;
        Stream.of("a", "b", "c");  // поток из ээементов
        Stream.of(array); // поток из элемента массива
        Stream.of(list); // поток из списка List
        Stream.generate(Math::random); // генерация потока из рандомных чисел
        Stream stream1 = Arrays.stream(array);
        Stream stream2 = list.stream();
        Stream.concat(stream1, stream2); // объединение двух потоков в один
        IntStream.range(20,30);  // поток диапазоном 1 - 9
        IntStream.rangeClosed(20, 30); // поток диапозоном 1 - 10

        // Stream из строк буфера BufferedReader
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedReader.lines();

        // Stream из строк файла через статический метод класса Files
        Path path = Path.of("test.txt");
        try {
            Files.lines(path);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Stream из случайных чисел Random
        Random random = new Random();

        random.ints();

        random.longs();

        random.doubles();

    }
}
