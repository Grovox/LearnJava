package Multithreading;

public class LearnMultithreading {
    public static void main(String[] args) {
        // Способы создания потоков
        // 1 способ создание объектов класса Thread
        OneThread oneThread = new OneThread();
        Thread myOneThread = new Thread(oneThread);
        myOneThread.start();

        System.out.println("Привет из главного первому");

        // 2 способ создать потомка класса Thread
        TwoThread myTwoThread = new TwoThread();
        myTwoThread.start();

        System.out.println("Привет из главного второму");


        // Thread.sleep() позволяет приостановить выполнение потока
        Thread sleepThread = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 10; i++) {
                    System.out.println("Я спать!!!");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Я работаю!!!");
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        sleepThread.start();

        // Thread.yield() позволяет передать управление другим потокам
        Thread yieldThread = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 100; i++){
                    Thread.yield();
                    System.out.println("yieldThread");
                }
            }
        });
        yieldThread.start();

        // join() позволяет ждать завершения другого потока
        try {
            yieldThread.join(250);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //setPriority() устанавливает приоритет
        sleepThread.setPriority(Thread.MAX_PRIORITY);

        //getPriority() получить приоритет
        System.out.println(sleepThread.getPriority());

        //isAlive() проверяет жив ли поток
        System.out.println(sleepThread.isAlive());

        //setName() задает имя потока
        sleepThread.setName("sleep");

        //getName() получает имя потока
        System.out.println(sleepThread.getName());

        //getId() возвращает id потока
        System.out.println(sleepThread.getId());

    }
}
 class OneThread implements Runnable{
     @Override
     public void run() {
         System.out.println("Привет из первого побочного потока!!!");
     }
 }

 class TwoThread extends Thread{
     @Override
     public void run() {
         System.out.println("Привет из второго побочного потока!!!");
     }
 }