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
            arr[min] = temp; // 1
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
}

// SelectionSort, BubbleSort e InsertionSort son O(n²) en el peor caso
// ya que utilizan ciclos anidados (for+for o for+while)
// esto hace que las operaciones crezcan como n x n cuando aumenta el arreglo.

// QuickSort es O(n log n) en el caso promedio y mejor caso.
// En cada nivel de recursión se procesan n elementos (particion),
// y hay log n niveles cuando el pivote divide el arreglo equilibradamente.
// En el peor caso (arreglo ya ordenado, pivote siempre extremo) sube a O(n²).