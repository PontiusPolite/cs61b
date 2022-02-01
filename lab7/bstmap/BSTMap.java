package bstmap;

import java.security.InvalidKeyException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by Carson Crow on 1/31/2022
 */
public class BSTMap<K extends Comparable<K>, V extends Comparable<V>> implements Map61B<K, V>{

    private BSTNode root;
    private int size;

    /** Creates a new empty BSTMap. */
    public BSTMap() {
        root = null;
        size = 0;
    }

    private class BSTNode {
        public K key;
        public V val;
        public BSTNode left, right;

        /** Creates an empty node. */
        public BSTNode() {
            key = null;
            val = null;
            left = right = null;
        }

        public BSTNode(K node_key, V node_value) {
            key = node_key;
            val = node_value;
            left = right = null;
        }

        public BSTNode(K node_key, V node_value,
                       BSTNode left_child, BSTNode right_child) {
            key = node_key;
            val = node_value;
            left = left_child;
            right = right_child;
        }
    }

    /**
     * Removes all key value pairs from this map.
     */
    @Override
    public void clear() {
        root = null;
        size = 0;
    }

    /** Returns true if this tree contains a mapping for the specified key. */
    @Override
    public boolean containsKey(K key) {
        return find(key) != null;
    }

    /** Returns the value to which the specified key is mapped, or null if this
     * map contains no mapping for the key.
     */
    @Override
    public V get(K key) {
        BSTNode x = find(key);
        if (x == null) {
            return null;
        }
        return x.val;
    }

    /** Returns the BSTNode with the given key, or null if key is not found. */
    private BSTNode find(K find_key) {
        return findHelper(find_key, root);
    }

    /** Returns the BSTNode with the given key, or null if key is not found starting
     * at node T */
    private BSTNode findHelper(K find_key, BSTNode T) {
        if (T == null) {
            return null;
        }
        if (find_key.compareTo(T.key) == 0) {
            return T;
        }

        if (find_key.compareTo(T.key) < 0){
            return findHelper(find_key, T.left);
        } else {
            return findHelper(find_key, T.right);
        }
    }

    /** Returns the number of key-value mappings in this map. */
    @Override
    public int size() {
        return size;
    }

    /** Associates the specified value with the specified key in this map. */
    @Override
    public void put(K key, V value) {
        root = putHelper(root, key, value);
        size += 1;
    }

    /** Recursive helper to put new key value pairs into our mapping by keeping track of the current
     * node T
     */
    private BSTNode putHelper(BSTNode T, K put_key, V put_value) {
        if (T == null) {
            return new BSTNode(put_key, put_value);
        }
        if (put_key.compareTo(T.key) == 0) {
            T = new BSTNode(put_key, put_value, T.left, T.right);
        }
        if (put_key.compareTo(T.key) < 0) {
            T.left = putHelper(T.left, put_key, put_value);;
        } else {
            T.right = putHelper(T.right, put_key, put_value);
        }
        return T;
    }

    /** Returns a Set view of the keys contained in this map. Not required for Lab 7.
     * If you don't implement this, throw an UnsupportedOperationException. */
    @Override
    public Set<K> keySet() {
        Set<K> s = new HashSet<>();
        return keySetHelper(s, root);
    }

    private Set<K> keySetHelper(Set<K> s, BSTNode T) {
        if (T.left != null) {
            s.addAll(keySetHelper(s, T.left));
        }
        if (T.right != null) {
            s.addAll(keySetHelper(s, T.right));
        }
        s.add(T.key);

        return s;
    }

    /** Removes the mapping for the specified key from this map if present.
     * Not required for Lab 7. If you don't implement this, throw an
     * UnsupportedOperationException. */
    @Override
    public V remove(K key) throws UnsupportedOperationException{

        BSTNode kill = find(key);
        if (kill == null) {
            return null;
        }
        V return_value = kill.val;

        // no children - just null the node
        if (kill.left == null && kill.right == null) {
            kill = null;


        }

        return return_value;
    }

    /** Finds the node that is the predecessor of T by key value, or returns null if there is none. */
    private BSTNode findPredecessor(BSTNode T) {
        if (T.left != null) {
            BSTNode current = T.left;
            while (current.right != null) {
                current = current.right;
            }
            return current;
        }
        return null;
    }

    private BSTNode findSuccessor(BSTNode T) {
        if (T.right != null) {
            BSTNode current = T.right;
            while (current.left != null) {
                current = current.left;
            }
            return current;
        }
        return null;
    }

    /** Removes the entry for the specified key only if it is currently mapped to
     * the specified value. Not required for Lab 7. If you don't implement this,
     * throw an UnsupportedOperationException.*/
    @Override
    public V remove(K key, V value) throws UnsupportedOperationException {
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
