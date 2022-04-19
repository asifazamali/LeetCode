package HashMap;

import java.util.Objects;

class Node<K, V> {
    K key;
    V value;
    Node next;

    public Node() {
        next = null;
    }

    public Node(K key, V value) {
        this.key = key;
        this.value = value;
        next = null;
    }

    public V getValue() {
        return value;
    }
}

public class HashMap<K,V>{
    Node<K,V>[] array;
    int size;
    public HashMap(){
        size = 1000;
        array = new Node[size];
        init();
    }

    private void init() {
        for(int i =0; i < size; i++){
            array[i] = new Node<K, V>();
        }
    }

    public V get(K key){
        Node<K, V> node = getNode(key);
        if (Objects.isNull(node.next)) {
            return null;
        }
        return (V) node.next.getValue();
    }
    private Node<K, V> getNode(K key){
        int hash = key.hashCode();
        int loc = hash % size;
        Node<K, V> head = array[loc];
        Node<K, V> prev = head;
        Node<K, V> temp = head.next;
        while(temp != null){
            if(temp.key.equals(key)) break;
            prev = temp;
            temp = temp.next;
        }
        return prev;
    }
    public boolean remove(K key){
        Node<K, V> node = getNode(key);
        if(Objects.isNull(node.next)) return false;
        node.next = node.next.next;
        return true;
    }

    public void put(K key, V value){
        if(Objects.isNull(key)) return;
        Node<K, V> node = getNode(key);
        if(Objects.isNull(node.next)) node.next = new Node(key, value);
        else
            node.next.value = value;
    }
}
