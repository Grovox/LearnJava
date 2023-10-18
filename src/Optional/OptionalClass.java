package Optional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

public class OptionalClass {
    public static void main(String[] args) {
        // Класс Optional является оберткой типа для удобной обработки null

        // Создание Optional.
        // Существует несколько способов создания этого объекта
        // Для создания пустого используется метод empty()
        Optional<String> empty = Optional.empty();

        // Метод isPresent() проверяет наличие значения
        System.out.println(empty.isPresent());

        //Можно содрать из другой переменной с помощью метода of()
        String name = "Max";  // Если будет null то выдаст NullPointerException
        Optional<String> opt1 = Optional.of(name);

        // Для создания из другой переменной которая может быть null используется ofNullable()
        String pet = null;
        Optional<String> opt2 = Optional.ofNullable(pet);

        // Метод isEmpty() проверяет пустой ли объект, он противоположен isPresent()
        System.out.println(empty.isEmpty());

        // Обработка не пустых объектов
        Optional<String> opt3 = Optional.ofNullable("Wine again");
        opt3.ifPresent(val -> System.out.println(val.length()));

        // Метод orElse() позволяет получить значение и если оно пустое вернуть аргумент
        System.out.println(empty.orElse("None"));

        // Метод orElseGet() позволяет получить значение и если оно пустое вызвать функциональный интерфейс Supplier()
        System.out.println(empty.orElseGet(new Supplier<String>() {
            @Override
            public String get() {
                return "None";
            }
        }));
        System.out.println(empty.orElseGet(() -> "None"));

        // Метод get() позволяет получить элемент если он не null, иначе выдаст NoSuchElementException
        System.out.println(opt1.get());

        // Метод filter() возвращает Optional ели оно подходит под условие, иначе возвращает пустой Optional
        System.out.println(opt1.filter(val -> val == "Max"));
        System.out.println(opt1.filter(val -> val == "Nik"));

        // Метод map() берет существующие значение выполняет вычисление и возвращает их результат
        List<String> companyNames = Arrays.asList("paypal", "oracle", "", "microsoft", "", "apple");
        Optional<List<String>> listOptional = Optional.of(companyNames);
        System.out.println(listOptional.map(List::size).orElse(0));

        // Метод flatMap() позволяет неявно распаковывать элементы
        Person person = new Person("Владимир", 69);
        Optional<Person> personOptional = Optional.of(person);
        Optional<Optional<String>> nameOptionalWrapper = personOptional.map(Person::getName);
        Optional<String> nameOptional = nameOptionalWrapper.orElseThrow(IllegalArgumentException::new);
        System.out.println(nameOptional.orElse(""));

        System.out.println(personOptional.flatMap(Person::getName).orElse(""));
    }
}

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Optional<String> getName() {
        return Optional.ofNullable(name);
    }

    public Optional<Integer> getAge() {
        return Optional.ofNullable(age);
    }
}