import java.util.Collection;
import java.util.NoSuchElementException;
import java.util.Vector;

public class ListAdapter extends CollectionAdapter implements HList {
    /**
     * Aggiunge un elemento element nella posizione index della lista.
     * Il metodo aggiunge un elemento nella posizione index
     * e sposta tutti gli elementi successivi di una posizione a destra.
     * @param index posizione in cui viene inserito l'elemento specificato
     * @param element elemento che deve essere inserito.
     */
    public void add(int index, Object element) {
        while(index > size()) {
            super.v.addElement(null);
        }
        try {
        super.v.insertElementAt(element,index);
        } catch(Exception e) {
            throw new IllegalArgumentException();
        }
    }



    /**
     *
     * @param index
     * @param c
     * @return
     */
    public boolean addAll(int index, HCollection c) {
        if
        HIterator iter = c.iterator();
        boolean modified = false;
        while(iter.hasNext()) {
            v.insertElementAt(iter.next(),index);
            index++;
        }
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
        return super.v.elementAt(index);
    }

    public int hashCode() {
        int toRet = 0;
        for(int j = 0; j< this.size(); j++) {
            int aHash = super.v.elementAt(0).hashCode();
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
        return super.v.indexOf(o);
    }




    public int lastIndexOf(Object o) {

        for(int i = super.v.size()-1; i >= 0;i--) {
            if(super.v.elementAt(i).equals(o))
                return i;
        }
        return -1;
    }

    public HListIterator listIterator() {
        return new ListIteratorAdapter();
    }


    public HListIterator listIterator(int index) {
        return new ListIteratorAdapter(0,super.v.size(),index);
    }

    public Object remove(int index) {
        Object toRet = super.v.elementAt(index);
        super.v.removeElementAt(index);
        return toRet;
    }






    public Object set(int index, Object element) {
        Object toRet = super.v.elementAt(index);
        super.v.setElementAt(element,index);
        return toRet;
    }




    public HList subList(int fromIndex,int toIndex) {
        if(fromIndex < 0 || toIndex > super.v.size() || fromIndex > toIndex)
            throw new IndexOutOfBoundsException();
        return new SubListAdapter(fromIndex,toIndex);
    }

    public String toString() {
        String toRet = "";
        for(int i = 0; i<super.v.size();i++) {
            if (super.v.get(i) == null) {
                toRet += null + "\n";
            } else {
                toRet += super.v.get(i).toString() + "\n";
            }
        }
        return toRet;
    }



    private class ListIteratorAdapter extends IteratorAdapter implements HListIterator {

        public ListIteratorAdapter() {
            new ListIteratorAdapter(0, super.v.size(), false, 0);
        }
        public ListIteratorAdapter(int fromIndex, int toIndex,int aPosition) {
            if(aPosition > 0)
                new ListIteratorAdapter(fromIndex,toIndex,true,aPosition);
            else
                new ListIteratorAdapter(fromIndex, toIndex, false,aPosition);
        }
        private ListIteratorAdapter(int fromIndex, int toIndex, boolean removable,int aPosition) {
            new IteratorAdapter(fromIndex,toIndex,removable,aPosition);
        }

        /**
         * Inserts the specified element into the list.
         * The element is inserted immediately before the next element that would be returned by next,
         * if any, and after the next element that would be returned by previous, if any.
         * (If the list contains no elements, the new element becomes the sole element on the list.)
         * The new element is inserted before the implicit cursor: a subsequent call to next would be unaffected,
         * and a subsequent call to previous would return the new element.
         * @param o
         */
        public void add(Object o) {
            ListAdapter.this.add(super.position,o);
        }

        /**
         * Returns true if this list iterator has more elements when traversing the list in the reverse direction.
         * (In other words, returns true if previous would return an element rather than throwing an exception.)
         * @return true if the list iterator has more elements when traversing the list in the reverse direction.
         */
        public boolean hasPrevious() {
            if(super.position >super.from)
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
            int myPos = super.position;
            return myPos+1;
        }

        /**
         * Returns the previous element in the list.
         * This method may be called repeatedly to iterate through the list backwards,
         * or intermixed with calls to next to go back and forth.
         * @return the previous element in the list.
         */
        public Object previous() {
            if(super.position<=super.from)
                throw new NoSuchElementException();
            int curPos = super.position;
            super.position--;
            super.canRemove = true;

            return super.v.elementAt(curPos);
        }

        /**
         * Returns the index of the element that would be returned by a subsequent call to previous.
         * (Returns -1 if the list iterator is at the beginning of the list.)
         * @return
         */
        public int previousIndex() {
            int myPos = super.position;
            return myPos-1;
        }


        public void set(Object o) {
            ListAdapter.this.set(super.position,o);
        }
    }



}
