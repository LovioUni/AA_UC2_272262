/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ordenamientos;

/**
 *
 * @author Lenovo
 */
public class Main {
// Método para imprimir el arreglo
    public static void imprimirArreglo(int[] arr) {
        for (int num : arr) {  // recorre todos los elementos
            System.out.print(num + " ");  // Impresión
        }
        System.out.println();  // Salta linea
    }

    public static void main(String[] args) {
        // Declaración e inicialización del arreglo
        int[] miArreglo = {5, 4, 24, 3};  // Asignación

        System.out.println("Arreglo Original: ");
        imprimirArreglo(miArreglo);  //Llamada al metodo

        //Ordenamientos.selectionSort(miArreglo); // llamada a método
        //Ordenamientos.bubbleSort(miArreglo);   // llamada a método
        //Ordenamientos.insertionSort(miArreglo); // Llamada a metodo
        Ordenamientos.quickSort(miArreglo, 0, miArreglo.length - 1);

        System.out.println("Arreglo Ordenado: ");
        imprimirArreglo(miArreglo);   // llamada a método
    }
}

//Para cambiar de metodo de ordenamient solo hay que comentar y descomentar
// las lineas 27  y 28