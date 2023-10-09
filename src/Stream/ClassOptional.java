package Stream;

import java.util.Comparator;
import java.util.stream.Stream;

public class ClassOptional {
    public static void main(String[] args) {
        //Методы интерфейса Stream findAny(), findFirst(), max(), min() и reduce() возвращают объект класса Optional
        //Это объект-контейнер, который может содержать или не содержать нулевое значение.
        //Позволяет избавиться от проверки на null
        //Метод класса Optoinal – возвращает значение, если оно присутствует, в противном случае бросит NoSuchElementException .
        Stream.of("1", "22", "333")
                .max(Comparator.comparingInt(String::length))
                .get();
    }
}
