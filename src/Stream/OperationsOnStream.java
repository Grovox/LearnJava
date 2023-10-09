package Stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OperationsOnStream {
    public static void main(String[] args) {
        // Опирации делятся на 2 вида:
        // Intermediate(Промежуточные) - не меняют данные, а только задают логику их изменений
        // Terminated(Конечные) = запускают всю цепь опираций, закрывают поток и возвращяют модифицированные данные

        // Операции над потоком могут выполнятся паралельно
        List<String> list = new ArrayList<>();
        Stream<String> stream = list.stream();
        stream.parallel();

        //Промежуточный операции Intermediate(не выполняются пока нет операции Terminate)

        // Провести операции над каждым элементом
        Stream.of("a", "b", "c").peek(System.out::println);

        // Преобразование данных из одного типа в другой
        Stream.of(1, 2, 3).map((x) -> String.valueOf(x));
        Stream.of(1, 2, 3).map(String::valueOf);
        Stream.of("1", "2", "3").map(Integer::parseInt);

        // Отфильтровать элементы
        Stream.of(1, 2, 3, 4, 5).filter(n -> n < 4);

        // Удалить дублирующиеся элементы
        Stream.of(1, 2, 3, 2, 4, 2, 5).distinct();

        // Сортировка и обратная сортировка
        Stream.of(4, 2, 5, 3, 1).sorted();
        Stream.of(4, 2, 3, 1, 7).sorted(Comparator.reverseOrder());

        // Лимит колличества
        Stream.of(1, 2, 3, 4, 5, 6, 7).limit(4);

        // Пропустить первые элементы
        Stream.of(1, 2, 3, 4, 5).skip(4);

        // Сопоставить поток с развернутым потоком
        List<Person> person = new ArrayList<>();
        List<String> petNames = person.stream()
                .flatMap(x -> x.getPetName().stream())
                .collect(Collectors.toList());
        // Таким образом можно развернуть двумерный массив
        Integer[][] array2d = new Integer[][]{
                {1, 2, 3},
                {1, 2}
        };
        Arrays.stream(array2d).flatMap(Arrays::stream);

        // Конечные операции Terminate

        // Собрать элементы потока и преобразовать их к нужному типу
        List<String> collect1 = Stream.of("a", "b", "c").collect(Collectors.toList());

        // Преобразовать в строку
        String collect2 = Stream.of("a", "b", "c").collect(Collectors.joining());

        // Итерация по каждому элементу
        Stream.of("a", "b", "c").forEach(System.out::println);

        // Узнать количество элементов стрима
        Stream.of("a", "b", "c").count();

        // Найти минимальный и максимальный элемент
        Optional<Integer> max = Stream.of(1, 2, 3, 4, 5).max(Comparator.naturalOrder());
        Integer maximum = max.get();

        Integer minimum = Stream.of(1, 2, 3, 4, 5).min(Comparator.naturalOrder()).get();

        // Comparator Удобно задать лямбда-функции:
        Stream.of("a", "ab", "abc").min((s1, s2) -> s1.length() -s2.length()).get();
        Stream.of("a", "bb", "ccc").max(Comparator.comparingInt(String::length));

        // Найти первый полходящий элемент
        Stream.of(1, 2, 3, 4, 5, 6, 7).filter(e -> e % 2 == 0).parallel().findAny().get();

        // Все элементы соответствующий условию
        Stream.of(1, 2, 3, 4, 5).allMatch(e -> e > 0);

        // Все элементы не соответствующие условию
        Stream.of(1, 2, 3, 4, 5).noneMatch(e -> e > 0);

        // Хотя бы один элемент соответствует условию
        Stream.of(1, 2, 3, 4, 5).anyMatch(e -> e > 4);

        // Сумма элементов стрима
        List<Integer> integers = new ArrayList<>();
        integers.stream().mapToInt(i -> i).sum();

        // Операция сведения.
        // Позволяет получить один результат из последовательности.
        // Участники операции сведения:
        // Identity - элемент, который является начальным значение.
        // Accumulator - функция, принимающий два параметра: частичный результат и следующий элемент потока.
        // Combiner - функция, используемая для объединения частичного результата операции сокращения и типами реализации аккумулятора
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int sum1 = numbers.stream().reduce(0, Integer::sum);
        int sum2 = numbers.stream().reduce(0, (subtotal, element) -> subtotal + element);

        // Сумма элементов в параллельном потоке
        int sum3 = numbers.parallelStream().reduce(0, (a, b) -> a + b, Integer::sum);
        int sum4 = numbers.parallelStream().reduce(0, Integer::sum, Integer::sum);

        // Объединение списка строк в одну строку
        List<String> letters = Arrays.asList("a", "b", "c", "d", "e");
        String result1 = letters.stream().reduce("", String::concat);
        String result2 = letters.stream().reduce("", (partialString, element) -> partialString + element);

    }
}

class Person{
    List<String> petName;

    public List<String> getPetName() {
        return petName;
    }
}

