package LambdaExpressions;

public class ExampleSMA {
    public static void main(String[] args) {

        //  Анонимный класс
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Я только что реализовал функциональный интерфейс Runnable.");
            }
        }).start();
    }
}
