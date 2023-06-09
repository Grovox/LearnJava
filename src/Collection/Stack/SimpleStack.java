package Collection.Stack;

import Collection.ArrayList.SimpleArray;

public class SimpleStack<T> implements Stack<T> {

    public static void main(String[] args) {
        SimpleStack<String> simpleStack = new SimpleStack();

        simpleStack.push("q");
        simpleStack.push("qw");
        simpleStack.push("qwe");
        simpleStack.push("qwer");
        simpleStack.push("qwert");
        simpleStack.push("qwerty");

        System.out.println(simpleStack);

        System.out.println("\n-----------------------\n");

        System.out.println(simpleStack.pop());

        System.out.println(simpleStack);

    }

    SimpleArray<T> list = new SimpleArray<>();

    @Override
    public void push(T item) {
        list.add(0, item);
    }

    @Override
    public T pop() {
        return list.remove(0);
    }

    @Override
    public String toString() {
        return list.toString();
    }
}
