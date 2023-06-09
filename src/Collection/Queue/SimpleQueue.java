package Collection.Queue;

import Collection.ArrayList.SimpleArray;

public class SimpleQueue<T> implements Queue<T>{

    public static void main(String[] args) {
        Queue<String> stringQueue = new SimpleQueue<>();

        System.out.println(stringQueue.isEmpty());

        stringQueue.add("qwerty");
        stringQueue.add("asdfgh");
        stringQueue.add("zxcvbn");

        System.out.println(stringQueue.isEmpty());

        System.out.println("\n------------------------------\n");

        System.out.println(stringQueue);

        System.out.println("\n------------------------------\n");

        System.out.println(stringQueue.remove());

        System.out.println("\n------------------------------\n");


    }

    private SimpleArray<T> list = new SimpleArray<>();

    @Override
    public void add(T item) {
        list.add(item);
    }

    @Override
    public T remove() {
        return list.remove(0);
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public String toString() {
        return list.toString();
    }
}
