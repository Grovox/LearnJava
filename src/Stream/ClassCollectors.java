package Stream;

import java.util.*;
import java.util.stream.Collectors;

public class ClassCollectors {
    public static void main(String[] args) {
        // Метод collect() интерфейса Stream собирает данные в необходимую структуру данный.
        // Преобразование в list
        List list = new ArrayList<>();
        list.stream().collect(Collectors.toList());

        // Преобразование в Set
        list.stream().collect(Collectors.toSet());

        // Преобразование в Map
        Map<String, String> map = new HashMap();
        map.entrySet().stream().map(e -> String.valueOf(e).split("=")).collect(Collectors.toMap(e -> e[0], e -> e[1]));

        // Объединение элементов в строку String
        list.stream().collect(Collectors.joining());

        // Сумма элементов в потоке
        List<Employee> employees = new ArrayList<>();
        employees.stream().collect(Collectors.summarizingDouble(Employee::getSalary));

        // Сгруппировать элементы по условию
        List<Man> mens = new ArrayList<>();
        mens.stream().collect(Collectors.groupingBy(Man::getCountry));



    }
}

class Man{
    int country;

    public int getCountry() {
        return country;
    }
}

class Employee{
    double salary;

    public double getSalary() {
        return salary;
    }
}