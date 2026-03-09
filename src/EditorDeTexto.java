import java.util.Scanner;

public class EditorDeTexto {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Pila pilaPrincipal = new Pila(100);
        Pila pilaSecundaria = new Pila(100);

        boolean salir = false;

        while (!salir) {

            System.out.println("\n===== MENU =====");
            System.out.println("1. Escribir texto");
            System.out.println("2. Deshacer (Undo)");
            System.out.println("3. Rehacer (Redo)");
            System.out.println("4. Mostrar texto actual");
            System.out.println("5. Salir");

            System.out.print("Seleccione una opción: ");
            int opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {

                case 1:
                    System.out.print("Ingrese texto: ");
                    String texto = sc.nextLine();
                    pilaPrincipal.push(texto);

                    // limpiar pila redo
                    pilaSecundaria = new Pila(100);
                    break;

                case 2:
                    if (!pilaPrincipal.isEmpty()) {
                        String eliminado = pilaPrincipal.pop();
                        pilaSecundaria.push(eliminado);
                        System.out.println("Última acción deshecha.");
                    } else {
                        System.out.println("No hay acciones para deshacer.");
                    }
                    break;

                case 3:
                    if (!pilaSecundaria.isEmpty()) {
                        String restaurado = pilaSecundaria.pop();
                        pilaPrincipal.push(restaurado);
                        System.out.println("Acción rehecha.");
                    } else {
                        System.out.println("No hay acciones para rehacer.");
                    }
                    break;

                case 4:
                    System.out.println("\nTexto actual:");
                    pilaPrincipal.mostrar();
                    break;

                case 5:
                    salir = true;
                    System.out.println("Programa finalizado.");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }
        }

        sc.close();
    }
}
