import java.util.*;
import java.util.function.UnaryOperator;

public class ListAdapter<E> extends Vector<E> implements List<E> {

    //unimplemented methods

    @Override
    public void add(int index, E element) {

    }

    @Override
    public boolean add(E e) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean equals(Object o) {
        return false;
    }

    @Override
    public E get(int index) {
        return null;
    }

    public int hashCode() {
        return 0;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public E remove(int index) {
        return null;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public E set(int index, E element) {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }
    public void sort(Comparator<? super E> c) {

    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    //unsupported methods


    static <E> List<E> of() {
        throw new UnsupportedOperationException();
    }

    static <E> List<E> of(E e1) {
        throw new UnsupportedOperationException();
    }

    static <E> List<E> of(E e1,E e2) {
        throw new UnsupportedOperationException();
    }

    static <E> List<E> of(E e1,E e2,E e3) {
        throw new UnsupportedOperationException();
    }

    static <E> List<E> of(E e1,E e2,E e3,E e4) {
        throw new UnsupportedOperationException();
    }

    static <E> List<E> of(E e1,E e2,E e3,E e4,E e5) {
        throw new UnsupportedOperationException();
    }

    static <E> List<E> of(E e1,E e2,E e3,E e4,E e5,E e6) {
        throw new UnsupportedOperationException();
    }

    static <E> List<E> of(E e1,E e2,E e3,E e4,E e5,E e6,E e7) {
        throw new UnsupportedOperationException();
    }

    static <E> List<E> of(E e1,E e2,E e3,E e4,E e5,E e6,E e7,E e8) {
        throw new UnsupportedOperationException();
    }

    static <E> List<E> of(E e1,E e2,E e3,E e4,E e5,E e6,E e7,E e8,E e9) {
        throw new UnsupportedOperationException();
    }

    static <E> List<E> of(E e1,E e2,E e3,E e4,E e5,E e6,E e7,E e8,E e9,E e10) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void replaceAll(UnaryOperator<E> operator) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Spliterator spliterator() {
        throw new UnsupportedOperationException();
    }
}
