public class Pila {

    private String[] elementos;
    private int cima;
    private int capacidad;

    public Pila(int capacidad) {
        this.capacidad = capacidad;
        elementos = new String[capacidad];
        cima = -1;
    }

    // Push
    public void push(String elemento) {
        if (cima < capacidad - 1) {
            elementos[++cima] = elemento;
        } else {
            System.out.println("La pila está llena");
        }
    }

    // Pop
    public String pop() {
        if (!isEmpty()) {
            return elementos[cima--];
        }
        return null;
    }

    // Peek
    public String peek() {
        if (!isEmpty()) {
            return elementos[cima];
        }
        return null;
    }

    // Verificar si está vacía
    public boolean isEmpty() {
        return cima == -1;
    }

    // Mostrar contenido
    public void mostrar() {
        if (isEmpty()) {
            System.out.println("No hay texto.");
            return;
        }

        for (int i = 0; i <= cima; i++) {
            System.out.println(elementos[i]);
        }
    }
}