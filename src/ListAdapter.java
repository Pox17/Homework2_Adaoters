import java.util.Collection;
import java.util.Vector;

public class ListAdapter implements HList {
    private Vector v;

    public ListAdapter() {
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
     * Aggiunge un elemento element nella posizione index della lista.
     * Il metodo aggiunge un elemento nella posizione index
     * e sposta tutti gli elementi successivi di una posizione a destra.
     * @param index posizione in cui viene inserito l'elemento specificato
     * @param element elemento che deve essere inserito.
     */
    public void add(int index, Object element) {
        while(index > size()) {
            v.addElement(null);
        }
        v.insertElementAt(element,index);
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
     *
     * @param index
     * @param c
     * @return
     */
    public boolean addAll(int index, HCollection c) {
        return false;
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

    /**
     * Returns true if this list contains all of the elements of the specified collection.
     * @param c collection to be checked for containment in this list.
     * @return true if this list contains all of the elements of the specified collection.
     */
    public boolean containsAll(HCollection c) {
        HIterator iter = c.iterator();
        while((iter.hasNext())) {
            if(!(contains(iter.next())))
                return false;
        }
        return true;
    }

    /**
     * Compares the specified object with this list for equality.
     * Returns true if and only if the specified object is also a list, both lists have the same size,
     * and all corresponding pairs of elements in the two lists are equal.
     * @param o the object to be compared for equality with this list.
     * @return true if the specified object is equal to this list.
     */
    public boolean equals(Object o) {
        if(o==null)
            return false;
        HList oList = null;
        try {
            oList = (HList) o;
        } catch(ClassCastException e) {
            return false;
        }
        if(oList == null)
            return false;
        int i = 0;
        HIterator oIter = oList.iterator();
        HIterator iter = iterator();
        while(oIter.hasNext() && iter.hasNext()) {
            if(!(iter.next().equals(oIter.next())))
                return false;

        }
        return true;
    }

    /**
     * Returns the element at the specified position in this list.
     * @param index  index of element to return.
     * @return the element at the specified position in this list.
     */
    public Object get(int index) {
        return v.elementAt(index);
    }

    public int hashCode() {
        int toRet = 0;
        for(int j = 0; j< this.size(); j++) {
            int aHash = v.elementAt(0).hashCode();
            toRet = this.size() * toRet + aHash;
        }
        return toRet;
    }

    /**
     * Returns the index in this list of the first occurrence of the specified element,
     * or -1 if this list does not contain this element.
     * @param o element to search for.
     * @return the index in this list of the last occurrence of the specified element,
     * or -1 if this list does not contain this element.
     */
    public int indexOf(Object o) {
        return v.indexOf(o);
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


    public HListIterator listIterator() {
        return null;
    }

    @Override
    public HListIterator listIterator(int index) {
        return null;
    }

    /**
     * Removes the first occurrence in this list of the specified element.
     * If this list does not contain the element, it is unchanged.
     * @param o  element to be removed from this list, if present.
     * @return true if this list contained the specified element.
     */
    public boolean remove(Object o) {
        return v.remove(o);
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










    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }



    @Override
    public Object remove(int index) {
        return null;
    }

    @Override
    public Object set(int index, Object element) {
        return null;
    }

    @Override
    public HList subList() {
        return null;
    }

    public String toString() {
        String toRet = "";
        for(int i = 0; i<v.size();i++) {
            if (v.get(i) == null) {
                toRet += null + "\n";
            } else {
                toRet += v.get(i).toString() + "\n";
            }
        }
        return toRet;
    }

    private class IteratorAdapter implements HIterator {

        private int position = 0;
        private boolean canRemove = false;


        public boolean hasNext() {
            if(position < size())
                return true;
            return false;
        }


        public Object next() {
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

    private class ListIteratorAdapter implements HListIterator {

        private int position;
        private boolean canRemove;

        public ListIteratorAdapter() {
            new ListIteratorAdapter(0);
        }

        public ListIteratorAdapter(int index) {
            position = index;
            if(position > 0)
                canRemove = true;
            else
                canRemove = false;
        }

        public void add(Object o) {
        }

        /**
         * Returns true if this list iterator has more elements when traversing the list in the reverse direction.
         * (In other words, returns true if previous would return an element rather than throwing an exception.)
         * @return true if the list iterator has more elements when traversing the list in the reverse direction.
         */
        public boolean hasPrevious() {
            if(position >=0)
                return true;
            return false;
        }

        /**
         * Returns the index of the element that would be returned by a subsequent call to next.
         * (Returns list size if the list iterator is at the end of the list.)
         * @return the index of the element that would be returned by a subsequent call to next,
         *         or list size if list iterator is at end of list.
         */
        public int nextIndex() {
            int myPos = position;
            return myPos+1;
        }

        /**
         * Returns the previous element in the list.
         * This method may be called repeatedly to iterate through the list backwards,
         * or intermixed with calls to next to go back and forth.
         * @return the previous element in the list.
         */
        public Object previous() {
            return null;
        }

        /**
         * Returns the index of the element that would be returned by a subsequent call to previous.
         * (Returns -1 if the list iterator is at the beginning of the list.)
         * @return
         */
        public int previousIndex() {
            int myPos = position;
            return myPos-1;
        }


        public void set(Object o) {

        }

        public boolean hasNext() {
            if(position < size())
                return true;
            return false;
        }

        public Object next() {
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
