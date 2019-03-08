package colaConPrioridad;

public class QueuePriority <T extends Comparable<T>> {
//  El mundo me la pela
//  Si lees esto pongale 10 al grupo en todas las unidades o tendrá mala suerte
    private Node<T> tail;
    private int     size;
    private Node<T> prio0;
    private Node<T> prio1;
    private Node<T> prio2;
    private Node<T> prio3;
    private Node<T> prio4;
    
    public QueuePriority() {
        this(5);
    }
    
    public QueuePriority(int siz) {
        if (siz <= 0)
            siz = 5;
        this.size = siz;
        tail  = new Node<>();
        prio0 = new Node<>();
        prio1 = new Node<>();
        prio2 = new Node<>();
        prio3 = new Node<>();
        prio4 = new Node<>();
        tail.setBack(prio0);
        prio0.setBack(prio1);
        prio1.setBack(prio2);
        prio2.setBack(prio3);
        prio3.setBack(prio4);
    }
    
    public void isEmpty(Node<T> node) throws isEmptyException {
        if (node.getCount() == 0)
            throw new isEmptyException("Empty Queue");
    }
    
    public void isFull(Node<T> node) throws isFullException {
        if (node.getCount() == size)
            throw new isFullException("Full Queue");
    }
    
    public boolean enQueue(T value, int priority) {
        if (value == null || priority < 0 || priority > 4)
            return false;
        else {
            try {
                Node<T> head = getPriority(priority);
                isFull(head);
                Node<T> _new = new Node<>(value);
                if (head.getNext() == null)
                    head.setNext(_new);
                else {
                    _new.setBack(getLastElement(head));
                    _new.getBack().setNext(_new);
                }
                head.setCount(head.getCount() + 1);
                return true;
            } catch(isFullException e) {
                System.out.println("El valor [" + value + 
                        "] no se pudo introducir a la prioridad [" + priority + "]");
                System.out.println(e.getMessage());
                return false;
            }
            
        }
        
    }
    
    public T deQueue(int priority) {
        if (priority < 0 || priority > 4) {
            System.out.println("No existe la prioridad [" + priority + "]");
            return null;
        } else {
            Node<T> head = getPriority(priority);
            try {
                isEmpty(head);
                Node<T> ref = head.getNext();
                T value = ref.getValue();
                if (ref.getNext() == null) {
                    head.setNext(null);
                    ref = null;
                } else {
                    ref.getNext().setBack(null);
                    head.setNext(ref.getNext());
                    ref.setNext(null);
                    ref = null;
                }
                head.setCount(head.getCount() - 1);
                System.gc();
                return value;
            } catch (isEmptyException e) {
                System.out.println("No hay nada que remover de la prioridad ["
                        + priority + "]");
                System.out.println(e.getMessage());
                System.out.println("");
                return null;
            }
            
        }
        
    }
    
    public void removeAll() {
        removeAllPart2(prio0, 0);
        removeAllPart2(prio1, 1);
        removeAllPart2(prio2, 2);
        removeAllPart2(prio3, 3);
        removeAllPart2(prio4, 4);
    }
    
    private boolean removeAllPart2(Node<T> node, int priority) {
        if (node.getNext() == null)
            return true;
        else {
            deQueue(priority);
            return removeAllPart2(node, priority);
        }
        
    }
    
    public T front(int priority) {
        if (priority < 0 || priority > 4) {
            System.out.println("No existe la prioridad [" + priority + "]");
            return null;
        } else {
            Node<T> head = getPriority(priority);
            try {
                isEmpty(head);
                return head.getNext().getValue();
            } catch (isEmptyException e) {
                System.out.println("No hay front en la prioridad [" + priority + "]");
                System.out.println(e.getMessage());
                System.out.println();
                return null;
            }
            
        }
        
    }
    
    public T last(int priority) {
        if (priority < 0 || priority > 4) {
            System.out.println("No existe la prioridad [" + priority + "]");
            return null;
        } else {
            Node<T> head = getPriority(priority);
            try {
                isEmpty(head);
                return getLastElement(head).getValue();
            } catch (isEmptyException e) {
                System.out.println("No hay last en la prioridad [" + priority +"]");
                System.out.println(e.getMessage());
                System.out.println();
                return null;
            }
            
        }
        
    }
    
    public Node<T> getPriority(int priority) {
        if (priority  < 0 || priority > 4)
            return null;
        else
            return getPriorityPart2(tail, 0, priority);
    }
    
    private Node<T> getPriorityPart2(Node<T> node, int i, int priority) {
        if (i == priority)
            return node.getBack();
        else
            return getPriorityPart2(node.getBack(), i + 1, priority);
        
    }
    
    private Node<T> getLastElement(Node<T> node) {
        if (node.getNext() == null)
            return node;
        else
            return getLastElement(node.getNext());
    }
    
    public boolean printPriority(int priority) {
        Node<T> head = getPriority(priority);
        System.out.println("Los valores en la prioridad [" + priority + "] son:");
        if (head.getNext() == null)
            return false;
        else {
            printPriorityPart2(head);
            System.out.println();
            return true;
        }
        
    }
    
    public void printPriorityPart2(Node<T> node) {
        if (node.getNext() != null) {
            System.out.print(" " + node.getNext().getValue());
            printPriorityPart2(node.getNext());
        }
        
    }
    
}
