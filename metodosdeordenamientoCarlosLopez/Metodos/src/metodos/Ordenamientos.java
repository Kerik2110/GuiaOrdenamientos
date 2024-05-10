package metodos;

public class Ordenamientos {

    private void MuestraArray(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print("[" + a[i] + "]");
        }
        System.out.println("");
        System.out.println("");
    }

    public void BubleSort(int[] a) {
        System.out.println("Array antes: ");
        this.MuestraArray(a);
        int n = a.length;
        int temp = 0;
        int comparaciones = 0; // Contador de comparaciones
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                comparaciones++; // Incrementa el contador de comparaciones
                if (a[j - 1] > a[j]) {
                    // Intercambio
                    temp = a[j - 1];
                    a[j - 1] = a[j];
                    a[j] = temp;
                }
                // Muestra el estado actual del arreglo en cada iteración
                System.out.print("Comparacion " + comparaciones + ": ");
                this.MuestraArray(a);
            }
        }
        System.out.println("Comparaciones: " + comparaciones);
    }

    public void InsertionSort(int[] a) {
        System.out.println("Array antes: ");
        this.MuestraArray(a);
        int n = a.length;
        int comparaciones = 0;
        for (int i = 1; i < n; i++) {
            int valorActual = a[i];
            int j = i - 1;
            while (j >= 0 && a[j] > valorActual) {
                comparaciones++;
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = valorActual;

            System.out.print("Comparacion " + comparaciones + ": ");
            this.MuestraArray(a);
        }
        System.out.println("Comparaciones: " + comparaciones);
    }

    public void SelectionSort(int[] a) {
        System.out.println("Array antes: ");
        this.MuestraArray(a);
        int n = a.length;
        int comparaciones = 0;
        for (int i = 0; i < n - 1; i++) {
            int indiceMinimo = i;
            for (int j = i + 1; j < n; j++) {
                comparaciones++;
                if (a[j] < a[indiceMinimo]) {
                    indiceMinimo = j;
                }
            }
            // Intercambiar arreglo[i] 
            //y arreglo[indiceMinimo]
            int temp = a[i];
            a[i] = a[indiceMinimo];
            a[indiceMinimo] = temp;

            System.out.print("Comparacion " + comparaciones + ": ");
            this.MuestraArray(a);
        }
        System.out.println("Comparaciones: " + comparaciones);
    }

    public void ShellSort(int[] a) {
        System.out.println("Array antes: ");
        this.MuestraArray(a);
        int n = a.length;
        int incremento = n;
        int comparaciones = 0;
        do {
            incremento = incremento / 2;
            for (int k = 0; k < incremento; k++) {
                for (int i = incremento + k; i < n; i += incremento) {
                    int j = i;
                    while (j - incremento >= 0 && a[j] < a[j - incremento]) {
                        comparaciones++;
                        int tmp = a[j];
                        a[j] = a[j - incremento];
                        a[j - incremento] = tmp;
                        j -= incremento;
                    }
                }
                System.out.print("Comparacion " + comparaciones + ": ");
                this.MuestraArray(a);
            }
        } while (incremento > 1);
        System.out.println("Comparaciones: " + comparaciones);
    }

    public void mergeSort(int[] a) {
        System.out.println("Array antes: ");
        this.MuestraArray(a);
        int comparaciones = mergeSortHelper(a);
        System.out.println("Comparaciones: " + comparaciones);
    }

    private int mergeSortHelper(int[] a) {
        if (a.length < 2) {
            return 0; // No hay comparaciones cuando el arreglo tiene menos de 2 elementos
        }

        int mid = a.length / 2;
        int[] left = new int[mid];
        int[] right = new int[a.length - mid];

        System.arraycopy(a, 0, left, 0, mid);
        System.arraycopy(a, mid, right, 0, a.length - mid);

        int comparacionesLeft = mergeSortHelper(left);
        int comparacionesRight = mergeSortHelper(right);
        int comparacionesMerge = merge(a, left, right);

        this.MuestraArray(a); // Muestra el estado actual del arreglo después de combinar

        return comparacionesLeft + comparacionesRight + comparacionesMerge;
    }

    private int merge(int[] arr, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;
        int comparaciones = 0; // Contador de comparaciones

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[k] = left[i];
                i++;
            } else {
                arr[k] = right[j];
                j++;
            }
            k++;
            comparaciones++;
        }
        while (i < left.length) {
            arr[k] = left[i];
            i++;
            k++;
        }
        while (j < right.length) {
            arr[k] = right[j];
            j++;
            k++;
        }

        return comparaciones;
    }

    public void quickSort(int[] arr) {
        System.out.println("Array antes: ");
        this.MuestraArray(arr);
        quickSort(arr, 0, arr.length - 1);
    }

    private void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            this.MuestraArray(arr);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        int comparaciones = 0;

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
            comparaciones++;
        }
        swap(arr, i + 1, high);
        System.out.println("Comparaciones: " + comparaciones);
        return i + 1;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
