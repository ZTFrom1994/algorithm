package data;

import java.util.HashMap;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 自己实现一个Key为int类型的HashMap，基本功能有：put，get，size，remove
 *
 * @author 张涛
 * @date 6/9/21 2:19 PM
 */
public class MyHashMap<K, V> {
    private Node<K, V>[] table;
    private static final int DEFAULT_SIZE = 16;
    private int size;
    /**
     * 用于扩容
     */
    private static final double CAPACITY_RATIO = 0.75;

    public MyHashMap() {
        table = new Node[DEFAULT_SIZE];
        this.size = DEFAULT_SIZE;
    }

    public MyHashMap(int size) {
        int n = size - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        table = new Node[n + 1];
        this.size = n + 1;
    }

    private int hash(K key) {
        int h;
        return key == null ? 0 : (h = key.hashCode()) ^ h >>> 16;
    }

    private int tableIndex(K key) {
        int h = hash(key);
        return h & (size - 1);
    }

    public V get(K key) {
        int index = tableIndex(key);
        Node<K, V> node = table[index];
        if (node != null) {
            while (node != null) {
                if (node.key == key || node.key.equals(key)) {
                    return node.value;
                }
                node = node.next;
            }
        }
        return null;
    }

    public void put(K key, V value) {
        if (CAPACITY_RATIO * size > table.length) {
            //扩容
        }
        doPut(key, value);
    }

    private void doPut(K key, V value) {
        int idx = tableIndex(key);
        Node<K, V> firstNode = table[idx];
        if (firstNode == null) {
            table[idx] = new Node<K, V>(key, value);
        } else {
            Node<K, V> node = firstNode;
            while (node != null) {
                if (node.key == key || node.key.equals(value)) {
                    break;
                }
                node = node.next;
            }
            if (node == null) {
                node = new Node<K, V>(key, value);
                node.next = firstNode;
                table[idx] = node;
            } else {
                node.value = value;
            }
        }
    }

    class Node<K, V> {
        public V value;
        public K key;
        public Node next;

        public Node(K k, V v) {
            this.key = k;
            this.value = v;
        }
    }

    public static void main(String[] args) {
        MyHashMap myHashMap = new MyHashMap(2);
        myHashMap.put("123", "123");
        myHashMap.put("456", "456");
        myHashMap.put("789", "789");
        System.out.println(myHashMap.get("123"));
        System.out.println(myHashMap.get("456"));
        System.out.println(myHashMap.get("789"));
    }
}
