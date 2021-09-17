import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;

public class SetAdapter  implements HSet {
    private Hashtable h;

    public SetAdapter() {
        h = new Hashtable();
    }

    /**
     * Add non accetta null
     * @param o
     * @return
     */
    public boolean add(Object o) {
        if(o == null)
            throw new NullPointerException();
        if(h.containsKey(o))
            return false;
        h.put(o,o);
        return true;
    }


    public boolean addAll(HCollection c) {
        HIterator iter = c.iterator();
        boolean modified = false;
        while(iter.hasNext()) {
            Object toAdd = iter.next();
            if(this.add(toAdd))
                modified = true;

        }
        return modified;
    }

    public void clear() {
        h.clear();
    }


    public boolean contains(Object o) {
        return h.containsKey(o);
    }


    public boolean containsAll(HCollection c) {
        HIterator iter = c.iterator();
        while(iter.hasNext()) {
            if(!h.containsKey(iter.next())) {
                return false;
            }
        }
        return true;
    }

    public boolean equals(Object o) {
        HSet mySet = null;
        try {
             mySet = (HSet) o;
        } catch(Exception e) {
            return false;
        }
        if(mySet== null)
            return false;
        HIterator iter = iterator();
        while(iter.hasNext()) {
            if(!(mySet.contains(iter.next()))) {
                return false;
            }
        }
        return true;
    }

    public boolean isEmpty() {
        return h.isEmpty();
    }


    public HIterator iterator() {
        return new SetIteratorAdapter();
    }


    public boolean remove(Object o) {
        Object ret = h.remove(o);
        if(ret == null)
            return false;
        else
            return true;
    }


    public boolean removeAll(HCollection c) {
        HIterator iter = c.iterator();
        boolean modified = false;
        while(iter.hasNext()) {
            if(remove(iter.next())) {
                modified = true;
            }
        }
        return modified;
    }


    public boolean retainAll(HCollection c) {
        Enumeration keys = h.keys();
        boolean modified = false;
        while(keys.hasMoreElements()) {
            Object toDel = keys.nextElement();
            if(!(c.contains(toDel))) {
                h.remove(toDel);
                modified = true;
            }

        }
        return modified;
    }


    public int size() {
        return h.size();
    }


    public Object[] toArray() {
        Object[] a = new Object[h.size()];
        toArray(a);
        return a;
    }


    public Object[] toArray(Object[] a) {
        if(a == null)
            throw new NullPointerException();
        if(a.length<=h.size())
            a = new Object[h.size()];
        Enumeration keys = h.keys();
        int i = 0;
        while(keys.hasMoreElements()) {
            a[i++] = keys.nextElement();
        }
        return a;
    }

    private class SetIteratorAdapter implements HIterator {
        private Enumeration keys;
        private int position;
        private Object point;

        public SetIteratorAdapter() {
            keys = h.keys();
            position = 0;
            point = null;
        }

        public boolean hasNext() {
            return keys.hasMoreElements();
        }


        public Object next() {
            position++;
            point =  keys.nextElement();
            return point;
        }


        public void remove() {
            h.remove(point);
            keys = h.keys();
            for(int i = 0; i< position; i++) {
                point = keys.nextElement();
            }
        }
    }
}
