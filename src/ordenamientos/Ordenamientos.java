/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ordenamientos;
import java.util.Arrays;
/**
 *
 * @author Lenovo
 */
public class Ordenamientos {

    // Metodo de ordenamiento Selection Sort
    public static void selectionSort(int[] arr) {
        int n = arr.length;  // tamaño del arreglo. 1 operación

        // recorrer el arreglo
        for (int i = 0; i < n - 1; i++) {  // 1+n+n
            int min = i;   // se asume que el mínimo es la posición actual. 1

            // buscar el elemento más pequeño en el resto del arreglo
            for (int j = i + 1; j < n; j++) { // 1 + n + n
                if (arr[j] < arr[min]) {  // comparación. 1
                    min = j;    // actualizar posición del mínimo. 1
                }
            }

            // intercambio de elementos
            int temp = arr[i]; // 1
            arr[i] = arr[min]; // 1
            arr[min] = temp;   // 1
        }
    }

    // Ordena el arreglo comparando pares de elementos adyacentes
    // e intercambiándolos si están en el orden incorrecto
    public static void bubbleSort(int[] arr) {
        int n = arr.length; // 1

        // Este bucle externo controla el número de pasadas
        for (int i = 0; i < n - 1; i++) {  // 1 + n + n
            // Bucle interno, compara elementos adyacentes
            for (int j = 0; j < n - i - 1; j++) { // 1 + n + n
                // comparación entre elementos adyacentes
                if (arr[j] > arr[j + 1]) {  // 1
                    // intercambio de valores
                    int temp = arr[j];      // 1
                    arr[j] = arr[j + 1];    // 1
                    arr[j + 1] = temp;      // 1
                }
            }
        }
    }

    // Ordena el arreglo insertando cada elemento en su posición correcta
    // dentro de la parte ya ordenada del arreglo
    public static void insertionSort(int[] arr) {
        int n = arr.length;  // tamaño del arreglo. 1 operación
        // recorre desde el segundo elemento hasta el final
        for (int i = 1; i < n; i++) {  // 1 + n + n
            int key = arr[i];  // elemento actual a insertar. 1
            int j = i - 1;     // índice del elemento anterior. 1
            // desplaza los elementos mayores que key una posición a la derecha
            while (j >= 0 && arr[j] > key) {  // comparación. 1
                arr[j + 1] = arr[j];  // desplazamiento. 1
                j = j - 1;            // retrocede una posición. 1
            }
            arr[j + 1] = key;  // inserta key en su posición correcta. 1
        }
    }

    public static void quickSort(int[] arr, int inicio, int fin) {
        if (inicio < fin) {  // condición base: subarreglo tiene más de 1 elemento. 1

            // particionar y obtener la posición final del pivote
            int pivoteIndice = particion(arr, inicio, fin);  // llamada al método. 1

            System.out.println("Índice del pivote: " + pivoteIndice +
                               ". Arreglo actual: " + Arrays.toString(arr));  // impresión. 1

            // Sub arreglo Izquierdo: ordena elementos menores al pivote
            System.out.println("Izquierda");  // 1
            quickSort(arr, inicio, pivoteIndice - 1);  // llamada recursiva izquierda. 1

            // Sub arreglo Derecho: ordena elementos mayores al pivote
            System.out.println("Derecha");  // 1
            quickSort(arr, pivoteIndice + 1, fin);  // llamada recursiva derecha. 1
        }
    }

    // Coloca el pivote (último elemento) en su posición correcta
    // deja los menores a la izquierda y los mayores a la derecha
    public static int particion(int[] arr, int inicio, int fin) {
        int pivote = arr[fin];   // el pivote es siempre el último elemento. 1
        int i = inicio - 1;      // índice del último elemento menor al pivote. 1

        // recorrer el subarreglo comparando cada elemento con el pivote
        for (int j = inicio; j < fin; j++) {  // 1 + n + n
            if (arr[j] < pivote) {  // comparación con el pivote. 1
                i++;  // ampliar la zona de menores. 1

                // intercambio: mover elemento menor a la zona izquierda
                int temp = arr[i];  // 1
                arr[i] = arr[j];    // 1
                arr[j] = temp;      // 1
            }
        }

        // colocar el pivote en su posición correcta
        int temp = arr[i + 1];  // 1
        arr[i + 1] = arr[fin];  // 1
        arr[fin] = temp;        // 1

        return i + 1;  // retorna el índice final del pivote. 1
    }

    // -----------------------------------------------------------------------
    // MergeSort
    // Divide el arreglo en mitades de forma recursiva y luego las fusiona
    // ordenadas. Complejidad: O(n log n) en todos los casos.
    // -----------------------------------------------------------------------

    /**
     * MERGE-SORT(A, izquierda, derecha)
     *   Si izquierda < derecha entonces
     *     medio <- izquierda + (derecha - izquierda) / 2
     *     MERGE-SORT(A, izquierda, medio)
     *     MERGE-SORT(A, medio+1, derecha)
     *     MERGE(A, izquierda, medio, derecha)
     */
    public static void mergeSort(int[] arr, int izquierda, int derecha) {
        // Caso base: el subarreglo tiene 1 o 0 elementos, ya está ordenado
        if (izquierda < derecha) {
            // Calcular el punto medio evitando desbordamiento de enteros
            int medio = izquierda + (derecha - izquierda) / 2;

            // Llamada recursiva sobre la mitad izquierda
            mergeSort(arr, izquierda, medio);

            // Llamada recursiva sobre la mitad derecha
            mergeSort(arr, medio + 1, derecha);

            // Fusionar las dos mitades ya ordenadas
            merge(arr, izquierda, medio, derecha);
        }
    }

    // Fusiona dos subarreglos ordenados: arr[izquierda..medio] y arr[medio+1..derecha]
    public static void merge(int[] arr, int izquierda, int medio, int derecha) {

        // Calcular el tamaño de los dos sub-arreglos temporales
        int n1 = medio - izquierda + 1;  // tamaño de la mitad izquierda. 1
        int n2 = derecha - medio;         // tamaño de la mitad derecha.  1

        // Crear los arreglos temporales
        int[] izquierdaArr = new int[n1];  // 1
        int[] derechaArr   = new int[n2];  // 1

        // Copiar los datos del arreglo original a los sub-arreglos temporales
        for (int i = 0; i < n1; i++) {   // 1 + n1 + n1
            izquierdaArr[i] = arr[izquierda + i];  // 1
        }
        for (int j = 0; j < n2; j++) {   // 1 + n2 + n2
            derechaArr[j] = arr[medio + 1 + j];    // 1
        }

        int i = 0;           // índice del sub-arreglo izquierdo. 1
        int j = 0;           // índice del sub-arreglo derecho.   1
        int k = izquierda;   // índice de escritura en el arreglo original. 1

        // Mientras ambos sub-arreglos tengan elementos, insertar el menor
        while (i < n1 && j < n2) {  // comparación. 1
            // El <= hace el algoritmo estable (elementos iguales mantienen su orden)
            if (izquierdaArr[i] <= derechaArr[j]) {  // 1
                arr[k] = izquierdaArr[i];  // 1
                i++;                       // 1
            } else {
                arr[k] = derechaArr[j];    // 1
                j++;                       // 1
            }
            k++;  // 1
        }

        // Copiar los elementos restantes de la mitad izquierda (si los hay)
        while (i < n1) {           // 1
            arr[k] = izquierdaArr[i];  // 1
            i++;                       // 1
            k++;                       // 1
        }

        // Copiar los elementos restantes de la mitad derecha (si los hay)
        while (j < n2) {           // 1
            arr[k] = derechaArr[j];    // 1
            j++;                       // 1
            k++;                       // 1
        }
    }
}

// SelectionSort, BubbleSort e InsertionSort son O(n²) en el peor caso
// ya que utilizan ciclos anidados (for+for o for+while)
// esto hace que las operaciones crezcan como n x n cuando aumenta el arreglo.

// QuickSort es O(n log n) en el caso promedio y mejor caso.
// En cada nivel de recursión se procesan n elementos (particion),
// y hay log n niveles cuando el pivote divide el arreglo equilibradamente.
// En el peor caso (arreglo ya ordenado, pivote siempre extremo) sube a O(n²).

// MergeSort es O(n log n) en TODOS los casos (mejor, promedio y peor).
// Divide el arreglo log n veces y en cada nivel fusiona n elementos en total.
// Requiere O(n) de memoria auxiliar para los sub-arreglos temporales.