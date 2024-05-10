package metodos;

import java.util.Scanner;

public class Metodos {

    public static void main(String[] args) {
        System.out.println("Bienvenido a su programa");
        System.out.println("1. Burbuja");
        System.out.println("2. Insercion");
        System.out.println("3. Seleccion");
        System.out.println("4. ShellSort");
        System.out.println("5. MargeSort");
        System.out.println("6. QuickSort");

        Scanner leer = new Scanner(System.in);
        System.out.println("Ingrese una opcion");
        int opcion = leer.nextInt();

        Ordenamientos m = new Ordenamientos();
        int array[] = {54, 26, 93, 17, 77, 31, 44, 55, 20};

        switch (opcion) {
            case 1:
                m.BubleSort(array);
                break;
            case 2:
                m.InsertionSort(array);
                break;
            case 3:
                m.SelectionSort(array);
                break;
            case 4:
                m.ShellSort(array);
                break;
            case 5:
                m.mergeSort(array);
                break;
            case 6:
                m.quickSort(array);
                break;
            default:
                System.out.println("Error. Ingrese opcion valida");
        }
    }
}
