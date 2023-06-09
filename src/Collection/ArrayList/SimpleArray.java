package Collection.ArrayList;

import java.util.Arrays;
import java.util.Iterator;

public class SimpleArray<E> implements Simple<E> {

    public static void main(String[] args) {
        Simple<String> strings = new SimpleArray<>();

        System.out.println(strings.isEmpty());

        strings.add("q");
        strings.add("qw");
        strings.add("qwe");
        strings.add("qwer");
        strings.add("qwert");
        strings.add("qwerty");

        System.out.println(strings.isEmpty());

        System.out.println("\n------------------------------------\n");

        System.out.println(strings.get(2));

        System.out.println("\n------------------------------------\n");

        System.out.println(strings.size());

        System.out.println("\n------------------------------------\n");

        System.out.println(strings);

        strings.remove(1);

        System.out.println(strings);

        System.out.println("\n------------------------------------\n");

        Iterator iteratorStrings = strings.iterator();

        while (iteratorStrings.hasNext()){
            System.out.println(iteratorStrings.next());
        }

        System.out.println("\n------------------------------------\n");

        for (String s : strings){
            System.out.println(s);
        }

        System.out.println("\n------------------------------------\n");

        strings.add(2, "add");
        System.out.println(strings);

    }

    private E[] values;

    public SimpleArray() {
        values = (E[]) new Object[0];
    }

    @Override
    public boolean add(E e) {
        try {
        E[] temp = values;
        values = (E[]) new Object[temp.length + 1];
        System.arraycopy(temp,0, values, 0, temp.length);
        values[values.length - 1] = e;
            return true;
        }catch (ClassCastException ex){
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean add(int index, E e) {
        try {
            E[] temp = values;
            values = (E[]) new Object[temp.length + 1];
            System.arraycopy(temp,0, values , 0 , index);
            int amountElementAfterIndex = temp.length - index;
            System.arraycopy(temp, index, values, index + 1, amountElementAfterIndex);
            values[index] = e;
            return true;
        }catch (ClassCastException ex){
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public E remove(int index) {
        try {
            E e = values[index];
            E[] temp = values;
            values = (E[]) new Object[temp.length - 1];
            System.arraycopy(temp,0, values, 0, index);
            int amountElementAfterIndex = temp.length - index - 1;
            System.arraycopy(temp, index + 1, values, index, amountElementAfterIndex);
            return e;
        }catch (ClassCastException ex){
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public E get(int index) {
        return values[index];
    }

    @Override
    public int size() {
        return values.length;
    }

    @Override
    public boolean isEmpty() {
        if(values.length > 0){
            return true;
        }
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return new ArrayIterator<>(values);
    }

    @Override
    public String toString() {
        return Arrays.toString(values);
    }
}
