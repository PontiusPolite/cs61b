package bstmap;

import java.util.Iterator;
import java.util.Set;

/**
 * Created by Carson Crow on 1/31/2022
 */
public class BSTMap<K, V> implements Map61B<K, V>{

    /**
     * Removes all of the mappings from this map.
     */
    @Override
    public void clear() {

    }

    /** Returns true if this map contains a mapping for the specified key. */
    @Override
    public boolean containsKey(K key) {
        return false;
    }

    /** Returns the value to which the specified key is mapped, or null if this
     * map contains no mapping for the key.
     */
    @Override
    public V get(K key) {
        return null;
    }

    /** Returns the number of key-value mappings in this map. */
    @Override
    public int size() {
        return 0;
    }

    /** Associates the specified value with the specified key in this map. */
    @Override
    public void put(K key, V value) {

    }

    /** Returns a Set view of the keys contained in this map. Not required for Lab 7.
     * If you don't implement this, throw an UnsupportedOperationException. */
    @Override
    public Set keySet() {
        return null;
    }

    /** Removes the mapping for the specified key from this map if present.
     * Not required for Lab 7. If you don't implement this, throw an
     * UnsupportedOperationException. */
    @Override
    public V remove(K key) {
        return null;
    }

    /** Removes the entry for the specified key only if it is currently mapped to
     * the specified value. Not required for Lab 7. If you don't implement this,
     * throw an UnsupportedOperationException.*/
    @Override
    public V remove(K key, V value) {
        return null;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator iterator() {
        return null;
    }
}
