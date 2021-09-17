
public interface HList extends HCollection {
    boolean add(Object o);
    boolean addAll(HCollection c);
    void clear();
    boolean contains(Object o);
    boolean containsAll(HCollection c);
    boolean equals(Object o);
    int hashCode();
    boolean isEmpty();
    HIterator iterator();
    boolean remove(Object o);
    boolean removeAll(HCollection c);
    boolean retainAll(HCollection c);
    int size();
    Object[] toArray();
    Object[] toArray(Object[] a);
    void add(int index, Object element);
    boolean addAll(int index, HCollection c );
    Object get(int index);
    int indexOf(Object o);
    int lastIndexOf(Object o);
    HListIterator listIterator();
    HListIterator listIterator(int index);
    Object remove(int index);
    Object set(int index, Object element);
    HList subList(int fromIndex, int toIndex);

}
