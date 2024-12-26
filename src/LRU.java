import java.util.*;
public class LRU<K,V> {
    private int capacity;
    private Map<K, Node<K,V>> cache;
    private Node<K,V> head;
    private Node<K,V> tail;

    public LRU(int capacity){
        this.capacity = capacity;
        cache = new HashMap<>(capacity);
        head = new Node<>(null,null);
        tail = new Node<>(null,null);
        head.next = tail;
        tail.prev = head;
    }

    public synchronized V get(K key){
        Node<K,V> node = cache.get(key);
        if(node == null){
            return null;
        }
        moveToHead(node);
        return node.value;
    }
    public synchronized void put(K key, V value){
        Node<K, V> node = cache.get(key);
        if(node != null){
            node.value = value;
            moveToHead(node);
        }
        else {
            node = new Node<>(key,value);
            cache.put(key, node);
            addToHead(node);
            if(cache.size() > capacity){
                Node<K,V> removedNode = removeTail();
                cache.remove(removedNode.key);
            }
            System.out.println("Node added to cache successfully");
        }
    }
    public void addToHead(Node<K, V> node){
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }
    public void moveToHead(Node<K,V> node) {
        addToHead(node);
        removeNode(node);
    }
    public Node<K, V> removeTail() {
        Node<K,V> node = tail.prev;
        removeNode(node);
        return node;
    }
    public void removeNode(Node<K, V> node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    public void printCache() {
        Node<K, V> current = head.next;
        while (current != tail) {
            System.out.print("(" + current.key + ": " + current.value + ") ");
            current = current.next;
        }
        System.out.println();
    }
}
