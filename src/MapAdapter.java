import java.util.Collection;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

public class MapAdapter<K,V> extends Hashtable<K,V> implements Map<K,V>{

    //not yet implemented methods
    @Override
    public void clear() {

    }

    @Override
    public boolean containsKey(Object key) {
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        return false;
    }

    public static <K,V> Map.Entry<K,V> entry(K k, V v) {
        return null;
    }

    @Override
    public Set<Map.Entry<K,V>> entrySet() {
        return null;
    }

    public boolean equals(Object o) {
        return false;
    }

    @Override
    public V get(Object key) {
        return null;
    }

    public V getOrDefault(Object key, V defaultValue) {
        return null;
    }

    public int hashCode() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public Set keySet() {
        return null;
    }

    @Override
    public Object put(Object key, Object value) {
        return null;
    }

    @Override
    public void putAll(Map m) {

    }

    public V putIfAbsent(K key, V value) {
        return null;
    }

    @Override
    public V remove(Object key) {
        return null;
    }

    public boolean remove(Object key, Object value) {
        return false;
    }

    public V replace(K key, V value) {
        return null;
    }

    public boolean replace(K key, V oldValue, V newValue) {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Collection values() {
        return null;
    }

















    

    //unsupported methods

    /**
     * Unsupported method
     * @param key
     * @param remappingFunction
     * @return
     */
    @Override
    public Object compute(Object key, BiFunction remappingFunction) {
        throw new UnsupportedOperationException();
    }

    /**
     * Unsupported method
     * @param key
     * @param mappingFunction
     * @return
     */
    @Override
    public Object computeIfAbsent(Object key, Function mappingFunction) {
        throw new UnsupportedOperationException();
    }

    /**
     * Unsupported method
     * @param key
     * @param remappingFunction
     * @return
     */
    @Override
    public Object computeIfPresent(Object key, BiFunction remappingFunction) {
        throw new UnsupportedOperationException();
    }

    /**
     * Unsupported method
     * @param action
     */
    @Override
    public void forEach(BiConsumer action) {
        throw new UnsupportedOperationException();
    }

    /**
     * Unsupported method
     * @param key
     * @param value
     * @param remappingFunction
     * @return
     */
    @Override
    public Object merge(Object key, Object value, BiFunction remappingFunction) {
        throw new UnsupportedOperationException();
    }

    /**
     * unsupported method
     * @param <K>
     * @param <V>
     * @return
     */
    static <K, V> Map<K, V> of() {
        throw new UnsupportedOperationException();
    }


    /**
     * Unsupported method
     * @param k1
     * @param v1
     * @param <K>
     * @param <V>
     * @return
     */
    static <K, V> Map<K, V> of(K k1, V v1) {
        throw new UnsupportedOperationException();
    }

    /**
     * Unsupported method
     * @param k1
     * @param v1
     * @param k2
     * @param v2
     * @param <K>
     * @param <V>
     * @return
     */
    static <K, V> Map<K, V> of(K k1, V v1, K k2, V v2) {
        throw new UnsupportedOperationException();
    }

    /**
     * Unsupported method
     * @param k1
     * @param v1
     * @param k2
     * @param v2
     * @param k3
     * @param v3
     * @param <K>
     * @param <V>
     * @return
     */
    static <K, V> Map<K, V> of(K k1, V v1, K k2, V v2, K k3, V v3) {
        throw new UnsupportedOperationException();
    }

    /**
     * Unsupported method
     * @param k1
     * @param v1
     * @param k2
     * @param v2
     * @param k3
     * @param v3
     * @param k4
     * @param v4
     * @param <K>
     * @param <V>
     * @return
     */
    static <K, V> Map<K, V> of(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4) {
        throw new UnsupportedOperationException();
    }

    /**
     * Unsupported method
     * @param k1
     * @param v1
     * @param k2
     * @param v2
     * @param k3
     * @param v3
     * @param k4
     * @param v4
     * @param k5
     * @param v5
     * @param <K>
     * @param <V>
     * @return
     */
    static <K, V> Map<K, V> of(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5) {
        throw new UnsupportedOperationException();}

    /**
     * Unsupported method
      * @param k1
     * @param v1
     * @param k2
     * @param v2
     * @param k3
     * @param v3
     * @param k4
     * @param v4
     * @param k5
     * @param v5
     * @param k6
     * @param v6
     * @param <K>
     * @param <V>
     * @return
     */
    static <K, V> Map<K, V> of(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6) {
        throw new UnsupportedOperationException();}

    /**
     * Unsupported method
     * @param k1
     * @param v1
     * @param k2
     * @param v2
     * @param k3
     * @param v3
     * @param k4
     * @param v4
     * @param k5
     * @param v5
     * @param k6
     * @param v6
     * @param k7
     * @param v7
     * @param <K>
     * @param <V>
     * @return
     */
    static <K, V> Map<K, V> of(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6, K k7, V v7) {
        throw new UnsupportedOperationException();}

    /**
     * Unsupported method
     * @param k1
     * @param v1
     * @param k2
     * @param v2
     * @param k3
     * @param v3
     * @param k4
     * @param v4
     * @param k5
     * @param v5
     * @param k6
     * @param v6
     * @param k7
     * @param v7
     * @param k8
     * @param v8
     * @param <K>
     * @param <V>
     * @return
     */
    static <K, V> Map<K, V> of(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6, K k7, V v7, K k8, V v8) {
        throw new UnsupportedOperationException();}

    /**
     * Unsupported method
     * @param k1
     * @param v1
     * @param k2
     * @param v2
     * @param k3
     * @param v3
     * @param k4
     * @param v4
     * @param k5
     * @param v5
     * @param k6
     * @param v6
     * @param k7
     * @param v7
     * @param k8
     * @param v8
     * @param k9
     * @param v9
     * @param <K>
     * @param <V>
     * @return
     */
    static <K, V> Map<K, V> of(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6, K k7, V v7, K k8, V v8, K k9, V v9) {
        throw new UnsupportedOperationException();}

    /**
     * Unsupported method
     * @param k1
     * @param v1
     * @param k2
     * @param v2
     * @param k3
     * @param v3
     * @param k4
     * @param v4
     * @param k5
     * @param v5
     * @param k6
     * @param v6
     * @param k7
     * @param v7
     * @param k8
     * @param v8
     * @param k9
     * @param v9
     * @param k10
     * @param v10
     * @param <K>
     * @param <V>
     * @return
     */
    static <K, V> Map<K, V> of(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6, K k7, V v7, K k8, V v8, K k9, V v9, K k10, V v10) {
        throw new UnsupportedOperationException();}

    /**
     * Unsupported method
     * @param entries
     * @param <K>
     * @param <V>
     * @return
     */
    static <K, V> Map<K, V> ofEntries(Entry<? extends K, ? extends V>... entries) {throw new UnsupportedOperationException();}

    /**
     * Unsupported method
     * @param function
     */
    @Override
    public void replaceAll(BiFunction function) {
        throw new UnsupportedOperationException();
    }
}
