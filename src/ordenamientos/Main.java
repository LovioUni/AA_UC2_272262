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

    public static void imprimirArreglo(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        int[] miArreglo = {5, 4, 24, 3};

        System.out.println("Arreglo Original: ");
        imprimirArreglo(miArreglo);

        Ordenamientos.selectionSort(miArreglo);
        // Ordenamientos.bubbleSort(miArreglo);

        System.out.println("Arreglo Ordenado: ");
        imprimirArreglo(miArreglo);
    }
}