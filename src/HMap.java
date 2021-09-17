public interface HMap {
    void clear();
    boolean containsKey();
    boolean containsValue();
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
}
