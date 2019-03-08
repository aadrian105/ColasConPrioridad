package colaConPrioridad;

public class Main {
    
    public static void main(String[] args) {
        QueuePriority<Double> prueba = new QueuePriority<>();
        
        try { // Comprobación del deQueue
            prueba.isEmpty(prueba.getPriority(3));
            System.out.println("El valor [" + prueba.deQueue(3) + "] fue removido de la prioridad 3");
        } catch (isEmptyException e) {
            System.out.println("No hay nada que remover en la prioridad 3");
            System.out.println(e.getMessage());
        }
        
        try { // Comprobación del front
            prueba.isEmpty(prueba.getPriority(3));
            System.out.println("El front de la prioridad 3 es [" + prueba.front(3) + "]");
        } catch (isEmptyException e) {
            System.out.println("No hay front en la prioridad 3");
            System.out.println(e.getMessage());
        }
        
        try { // Comprobación del last
            prueba.isEmpty(prueba.getPriority(3));
            System.out.println("El last de la prioridad 3 es [" + prueba.last(3) + "]");
        } catch (isEmptyException e) {
            System.out.println("No hay last en la prioridad 3");
            System.out.println(e.getMessage());
        }
         
        prueba.enQueue(01d, 0);
        prueba.enQueue(02d, 1);
        prueba.enQueue(03d, 1);
        prueba.enQueue(04d, 2);
        prueba.enQueue(05d, 2);
        prueba.enQueue(06d, 2);
        prueba.enQueue(07d, 3);
        prueba.enQueue(08d, 3);
        prueba.enQueue(09d, 3);
        prueba.enQueue(10d, 3);
        prueba.enQueue(11d, 4);
        
        try {
            prueba.isEmpty(prueba.getPriority(3));
            System.out.println("El valor [" + prueba.deQueue(3) + "] fue removido de la prioridad 3");
        } catch (isEmptyException e) {
            System.out.println("No hay nada que remover en la prioridad 3");
            System.out.println(e.getMessage());
        }
        
        try { // Comprobación del front
            prueba.isEmpty(prueba.getPriority(3));
            System.out.println("El front de la prioridad 3 es [" + prueba.front(3) + "]");
        } catch (isEmptyException e) {
            System.out.println("No hay front en la prioridad 3");
            System.out.println(e.getMessage());
        }
        
        try { // Comprobación del last
            prueba.isEmpty(prueba.getPriority(3));
            System.out.println("El last de la prioridad 3 es [" + prueba.last(3) + "]");
        } catch (isEmptyException e) {
            System.out.println("No hay last en la prioridad 3");
            System.out.println(e.getMessage());
        }
        
        prueba.enQueue(12d, 5); // Este regresa un falso, ya que no hay prioridad 5
        
        prueba.enQueue(13d, 3);
        prueba.enQueue(14d, 3); // Estos no se meterán ya que la prioridad 3 ya está llena
        prueba.enQueue(15d, 3);
        
        prueba.printPriority(0);
        prueba.printPriority(1);
        prueba.printPriority(2);
        prueba.printPriority(3);
        prueba.printPriority(4);
        
        prueba.removeAll();
        
        prueba.enQueue(16d, 0);
        //Aquí solo imprirá la lista 0, ya que las demás prioridades están vacías
        prueba.printPriority(0);
        prueba.printPriority(1);
        prueba.printPriority(2);
        prueba.printPriority(3);
        prueba.printPriority(4);
    }
    
}
