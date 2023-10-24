package Multithreading;

public class DaemonTread {
    public static void main(String[] args) {
        // Обычно программа работает пока не завершится последний поток
        // Чтоб при завершении главного потока завершился второй поток,
        // его надо объявить демоном
        // setDaemon(true) объявляет поток демоном

        Thread daemonThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println("Я демон!!!");
                }
            }
        });
        daemonThread.setDaemon(true);
        daemonThread.start();

        // isDaemon() позволяет узнать является ли поток демоном
        System.out.println(daemonThread.isDaemon());
    }
}
