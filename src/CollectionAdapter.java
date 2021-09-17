import org.junit.Test;

import java.util.Collection;
import java.util.NoSuchElementException;
import java.util.Vector;

import static org.junit.Assert.*;

public class CollectionAdapter implements HCollection {

    protected Vector v;

    public CollectionAdapter() {
        v = new Vector();
    }

    /**
     * Aggiunge un elemento alla in coda alla lista. La lista accetta null
     * @param o L'oggetto da inserire in coda alla lista
     * @return true se l'elemento viene inserito, false altrimenti.
     */
    public boolean add(Object o) {
        try {
            v.addElement(o);
        } catch(Exception e) {
            return false;
        }
        return true;
    }

    /**
     * Aggiunge tutti gli elementi della collezione c in coda alla lista.
     * @param c collezione di oggetti da aggiungere alla lista
     * @return true se la lista viene modificata, false altrimenti
     */
    public boolean addAll(HCollection c) {
        boolean modified = false;
        HIterator cIt = c.iterator();
        while(cIt.hasNext()) {
            if(this.add(cIt.next()))
                modified = true;
        }
        return modified;
    }
    /**
     * Rimuove tutti gli elementi dalla lista
     */
    public void clear() {
        v.clear();
    }

    /**
     * Returns true if this list contains the specified element.
     * @param o  element whose presence in this list is to be tested.
     * @return true if this list contains the specified element.
     */
    public boolean contains(Object o) {
        return v.contains(o);
    }

    public boolean containsAll(HCollection c) {
        if(c.size() >this.size())
            return false;
        int i = 0;
        while(!(c.isEmpty()) && i< this.size()) {
            if(c.contains(v.elementAt(i))) {
                c.remove(v.elementAt(i));

            }
            i++;
        }
        if(c.isEmpty())
            return true;
        return false;
    }

    /**
     * Returns true if this list contains no elements.
     * @return true if this list contains no elements.
     */
    public boolean isEmpty() {
        return v.isEmpty();
    }

    /**
     * Returns an iterator over the elements in this list in proper sequence.
     * @return an iterator over the elements in this list in proper sequence.
     */
    public HIterator iterator() {
        return new IteratorAdapter();
    }

    /**
     * Removes the first occurrence in this list of the specified element.
     * If this list does not contain the element, it is unchanged.
     * @param o  element to be removed from this list, if present.
     * @return true if this list contained the specified element.
     */
    public boolean remove(Object o) {
        return v.removeElement(o);
    }

    /**
     * Removes from this list all the elements that are contained in the specified collection
     * @param c collection that defines which elements will be removed from this list.
     * @return true if this list changed as a result of the call.
     */
    public boolean removeAll(HCollection c) {
        boolean changed = false;
        HIterator iter = c.iterator();
        while(iter.hasNext()) {
            if(remove(iter.next())) {
                changed = true;
            }

        }
        return changed;
    }

    public boolean retainAll(HCollection c) {
        boolean modified = false;
        HIterator iter = iterator();
        Object toElim = null;
        while(iter.hasNext()) {
            toElim = iter.next();
            if(!(c.contains(toElim))) {
                iter.remove();
                modified = true;
            }
        }
        return modified;
    }

    /**
     * Returns true if this list contains the specified element.
     * @return the number of elements in this list.
     */
    public int size() {
        return v.size();
    }


    /**
     * Returns an array containing all of the elements in this list in proper sequence.
     * @return an array containing all of the elements in this list in proper sequence.
     */
    public Object[] toArray() {
        Object[] toRet = new Object[size()];
        v.copyInto(toRet);
        return toRet;
    }

    /**
     *Returns an array containing all of the elements in this list in proper sequence;
     * the runtime type of the returned array is that of the specified array.
     * @param a  the array into which the elements of this list are to be stored, if it is big enough;
     *           otherwise, a new array of the same runtime type is allocated for this purpose.
     * @return an array containing the elements of this list.@return
     */
    public Object[] toArray(Object[] a) {
        if(a == null)
            throw new NullPointerException();
        if (a.length < this.size()) {
            Class aClass = a.getClass();
            a = new Object[size()];
        }
        v.copyInto(a);
        //controllare se funziona = null
        return a;
    }

    private class IteratorAdapter implements HIterator {
        private int from;
        private int to;
        private int position;
        private boolean canRemove;

        IteratorAdapter() {
            new IteratorAdapter(0, v.size(), false,0);
        }

        IteratorAdapter(int fromIndex, int toIndex, boolean removable, int aPosition) {
            from = fromIndex;
            to = toIndex;
            position = aPosition;
            canRemove = removable;
        }

        public boolean hasNext() {
            if(position < to)
                return true;
            return false;
        }


        public Object next() {
            if(position >= to - 1)
                throw new NoSuchElementException();
            int curPos = position;
            position++;
            canRemove = true;
            return v.elementAt(curPos);
        }

        public void remove() {
            if(!canRemove)
                throw new IllegalStateException();
            v.removeElementAt(position-1);
            position--;
        }
    }
}
