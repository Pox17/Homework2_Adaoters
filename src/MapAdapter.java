import java.util.Enumeration;
import java.util.Hashtable;

public class MapAdapter implements HMap {

    private Hashtable h;

    public MapAdapter() {
        h = new Hashtable();
    }

    public void clear() {
        h.clear();
    }


    public boolean containsKey(Object key) {
        return h.containsKey(key);
    }


    public boolean containsValue(Object value) {
        return h.containsValue(value);
    }


    public HSet entrySet() {
        HSet toRet = new SetAdapter();
        Enumeration keys = h.keys();
        while(keys.hasMoreElements()) {
            Object key = keys.nextElement();
            HEntry toAdd = new EntryAdapter(key,h.get(key));
            toRet.add(toAdd);
        }
        return toRet;
    }


    public Object get(Object key) {
        return h.get(key);
    }


    public boolean isEmpty() {
        return h.isEmpty();
    }


    public HSet keySet() {
        HSet toRet = new SetAdapter();
        Enumeration keys = h.keys();
        while(keys.hasMoreElements()) {
            toRet.add(keys.nextElement());
        }
        return toRet;
    }


    public Object put(Object key, Object value) {
        return h.put(key, value);
    }

    public void putAll(HMap t) {
        HSet es = t.entrySet();
        HIterator setIter = es.iterator();
        while(setIter.hasNext()) {
            HEntry entry = (HEntry)setIter.next();
            this.put(entry.getKey(),entry.getValue());
        }
    }

    public Object remove(Object key) {
        return h.remove(key);
    }


    public int size() {
        return h.size();
    }


    public HCollection values() {
        HCollection toRet = new ListAdapter();
        Enumeration keys = h.keys();
        while(keys.hasMoreElements()) {
            toRet.add(h.get(keys.nextElement()));
        }
        return toRet;
    }

    private class EntryAdapter implements HEntry {

        private Object key;
        private Object value;

        public EntryAdapter(Object aKey,Object aValue) {
            key = aKey;
            value = aValue;
        }

        public Object getKey() {
            return key;
        }


        public Object getValue() {
            return value;
        }


        public int HashCode() {
            int toRet = 0;
            toRet = key.hashCode() * value.hashCode();
            return toRet;
        }


        public Object setValue(Object aValue) {
            Object toRet = this.value;
            this.value = aValue;
            return toRet;
        }
    }
}
