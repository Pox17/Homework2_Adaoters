public interface HMap {
    void clear();
    boolean containsKey(Object key);
    boolean containsValue(Object value);
    HSet entrySet();
    boolean equals(Object o);
    Object get(Object key);
    int hashCode();
    boolean isEmpty();
    HSet keySet();
    Object put(Object key, Object value);
    void putAll(HMap t);
    Object remove(Object key);
    int size();
    HCollection values();
    interface HEntry {
        boolean equals(Object o);
        Object getKey();
        Object getValue();
        int HashCode();
        Object setValue(Object value);
    }
}
