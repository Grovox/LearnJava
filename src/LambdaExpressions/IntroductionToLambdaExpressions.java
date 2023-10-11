package LambdaExpressions;

public class IntroductionToLambdaExpressions {
    double getPiValue() {
        return 3.1415;
    }
    public static void main(String[] args) {
        // В Java, лямбда-выражения имеют следующий синтаксис:
        // (parameter list) -> lambda body

        // Предположим, у нас есть такой метод:
        // double getPiValue() {
        //     return 3.1415;
        // }
        // Мы можем записать его, используя лямбда, как:
        // () -> 3.1415

        // Типы лямбда-выражений
        // В Java, тело лямбды может быть двух типов.
        // 1. Однострочные
        // () -> System.out.println("Lambdas are great");
        // 2. Блочные (многострочные)
        // () -> {
        //     double pi = 3.1415;
        //     return pi;
        // };

        // Пример лямбда-выражение
        MyInterface1 ref1;
        ref1 = () -> 3.1415;
        System.out.println("Value of Pi = " + ref1.getPiValue());

        //Лямбда-выражения с параметрами
        //До этого момента, мы создавали лямбда-выражения без каких-либо параметров. Однако, как и методы, лямбды могут иметь параметры.

        // Пример лямбда-выражение с параметром
        MyInterface2 ref2 = (str) -> {

            String result = "";
            for (int i = str.length()-1; i >= 0; i--){
                result += str.charAt(i);
            }
            return result;
        };

        System.out.println("Lambda reversed = " + ref2.reverse("Lambda"));

        //Параметризированный функциональный интерфейс
        //До этого момента, мы использовали функциональные интерфейсы, которые принимали только один тип значения. Например:

        // Пример параметризованного лямбда-выражения
        MyInterface3<String> ref3 = (str) -> {
            String result = "";
            for (int i = str.length(); i >= 0; i--){
                result += str.charAt(i);
            }
            return result;
        };

        System.out.println("Lambda reversed = " + ref3.func("Lambda"));

    }
}

@java.lang.FunctionalInterface
interface MyInterface1{
    double getPiValue();
}

@java.lang.FunctionalInterface
interface MyInterface2 {
    // абстрактный метод
    String reverse(String n);
}

@java.lang.FunctionalInterface
interface MyInterface3<T> {
    // параметризированный метод
    T func(T t);
}