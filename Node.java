package colaConPrioridad;

public class Node<T extends Comparable<T>> {
    private T       value;
    private Node<T> next;
    private Node<T> back;
    private int     count;
    
    public Node() {
        this(null);
    }
    
    public Node(T value) {
        this.value = value;
        this.next  = null;
        this.back  = null;
        this.count = 0;
    }
    
    public T getValue() {
        return value;
    }
    
    public void setValue(T value) {
        this.value = value;
    }
    
    public Node<T> getNext() {
        return next;
    }
    
    public void setNext(Node<T> next) {
        this.next = next;
    }
    
    public Node<T> getBack() {
        return back;
    }
    
    public void setBack(Node<T> back) {
        this.back = back;
    }
    
    public int getCount() {
        return count;
    }
    
    public void setCount(int count) {
        this.count = count;
    }
    
}
