package Collection.ArrayList;

public interface Simple<E> extends Iterable<E> {

    boolean add(E e);
    boolean add(int index,E e);
    E remove(int index);
    E get(int index);
    int size();
    boolean isEmpty();
}
