/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ordenamientos;

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
}

// Ambos metodos de ordenamiento son O(n²) ya que se utilizan 2 ciclos for
// esto hace que las operaciones crezca como n x n, osea n² cuando se aumenta el tamaño del arreglo.