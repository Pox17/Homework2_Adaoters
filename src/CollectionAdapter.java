import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.Vector;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * La classe accetta tutto, in più istanze anche
 * @param <E>
 */
public class CollectionAdapter<E> extends Vector<E> implements Collection<E> {


    //implemented methods


    public boolean add(E e) {
        super.addElement(e);
        return true;
    }


    //da definire i vari controlli di addAll()

    public boolean addAll(Collection<? extends E> c) {
        boolean modified = false;
        Iterator<? extends E> cIt = c.iterator();
        while(cIt.hasNext()) {
            if(this.add(cIt.next()))
                modified = true;
        }
        return modified;
    }


    public void clear() {
        super.removeAllElements();
    }


    public boolean contains(Object o) {
        return super.contains(o);
    }

    //first try, non tiene conto della posizione, in una collection andrebbe tenuto(??)

    public boolean equals(Object o) {
        if(o==null)
            return false;
        Collection oCol = null;
        try {
            oCol = (Collection<E>) o;
        } catch(ClassCastException e) {
            return false;
        }
        if(oCol == null)
            return false;
        int i = 0;
        while(!(oCol.isEmpty()) && i< this.size()) {
            if(oCol.contains(this.elementAt(i))) {
                oCol.remove(this.elementAt(i));
            } else {
                return false;
            }
            i++;
        }
        if(oCol.isEmpty())
            return true;
        return false;
    }


    public int hashCode() {
        int toRet = 0;
        for(int j = 0; j< this.size(); j++) {
            int aHash = this.elementAt(0).hashCode();
            toRet = this.size() * toRet + aHash;
        }
        return toRet;
    }


    public boolean isEmpty() {
        return super.isEmpty();
    }


    public Iterator<E> iterator() {
        return new CollectionAdapterIterator<E>();
    }


    public boolean remove(Object o) {
        boolean toRet = super.removeElement(o);
        return toRet;
    }
    //da mettere a post, non si possono usare iteratori per ora 

    public boolean retainAll(Collection<?> c) {
        boolean modified = false;
        Iterator<E> iter = this.iterator();
        E toElim = null;
        while(iter.hasNext()) {
            toElim = iter.next();
            System.out.println(toElim.toString());
            System.out.println(c.contains(toElim));
            if(!(c.contains(toElim))) {
                System.out.println("Elimino dall'originale:" + toElim.toString());
                iter.remove();
                modified = true;
            } else {
                c.remove(toElim);
            }
        }
        return modified;
    }


    public int size() {
        return super.size();
    }

    public Object[] toArray() {
        Object[] toRet = new Object[size()];
        copyInto(toRet);
        return toRet;
    }

    public boolean containsAll(Collection<?> c) {
        if(c.size() >this.size())
            return false;
        int i = 0;
        while(!(c.isEmpty()) && i< this.size()) {
            if(c.contains(this.elementAt(i))) {
                c.remove(this.elementAt(i));

            }
            i++;
        }
        if(c.isEmpty())
            return true;
        return false;
    }

    public String toString() {
        String toRet = "";
        Iterator<E> iter = iterator();
        while(iter.hasNext()) {
            toRet += iter.next().toString() + "\n";
        }
        return toRet;
    }



    //not yet implemented methods






    //metodo da finire Ricordati

    public <T> T[] toArray(T[] a) {
        if(a == null)
            throw new NullPointerException();
        try {
            if (a.length < this.size()) {
                Class aClass = a.getClass();
                T[] array = (T[]) Array.newInstance(aClass.getComponentType(), size());
            }
        } catch(Exception e) {
            
        }
        return null;
    }


    //unsupported methods


    public Stream parallelStream() {
        throw new UnsupportedOperationException();

    }


    public boolean removeIf(Predicate filter) {
        throw new UnsupportedOperationException();

    }


    public Spliterator spliterator() {
        throw new UnsupportedOperationException();
    }


    public Stream stream() {
        throw new UnsupportedOperationException();
    }




    private class CollectionAdapterIterator<E> implements Iterator<E> {
        private int position = 0;
        private boolean canRemove = false;


        public boolean hasNext() {
            if(position < size())
                return true;
            return false;
        }


        public E next() {
            int curPos = position;
            position++;
            canRemove = true;
            return (E) elementAt(curPos);
        }

        public void remove() {
            if(!canRemove)
                throw new IllegalStateException();
            removeElementAt(position-1);
            position--;
        }
    }
}
