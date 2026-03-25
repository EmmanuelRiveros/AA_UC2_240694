package com.itson.ordenamientos;

import java.util.Arrays;

/**
 *
 * @author Emmanuel Riveros
 */

public class Ordenamientos {
    
    public static void main(String[] args) {
        
        Ordenamientos ordenador = new Ordenamientos();
        int[] arregloPrueba = {8, 3, 1, 7, 0, 10, 2};
        
        System.out.println("Arreglo original:");
        System.out.println(Arrays.toString(arregloPrueba));
        
        ordenador.quickSort(arregloPrueba, 0, arregloPrueba.length - 1);
        
        System.out.println("\nArreglo ordenado:");
        System.out.println(Arrays.toString(arregloPrueba));
    }
    
    // Método principal de QuickSort
    public void quickSort(int[] arr, int inicio, int fin) {
        // 1 comparación (inicio < fin)
        if (inicio < fin) {
            
            // 1 asignación, 1 llamada a método
            int indicePivote = particion(arr, inicio, fin);
            
            // 1 llamada a método, 1 resta algebraica
            quickSort(arr, inicio, indicePivote - 1);
            
            // 1 llamada a método, 1 suma algebraica
            quickSort(arr, indicePivote + 1, fin);
        }
    }

    // Método auxiliar para realizar la partición
    private int particion(int[] arr, int inicio, int fin) {
        // 1 asignación, 1 acceso a arreglo
        int pivote = arr[fin]; 
        
        // 1 asignación, 1 resta
        int i = (inicio - 1); 

        // 1 asignación (j=inicio); n comparaciones (j<fin); n incrementos (j++)
        for (int j = inicio; j < fin; j++) {
            
            // n accesos a arreglo, n comparaciones
            if (arr[j] <= pivote) {
                
                // n incrementos (en el peor de los casos)
                i++; 
                
                // Intercambio de arr[i] y arr[j]
                // n asignaciones, n accesos
                int temp = arr[i]; 
                // n asignaciones, 2n accesos
                arr[i] = arr[j]; 
                // n asignaciones
                arr[j] = temp; 
            }
        }

        // Intercambio final del pivote a su posición correcta
        // 1 asignación, 1 acceso, 1 suma
        int temp = arr[i + 1]; 
        // 1 asignación, 2 accesos, 1 suma
        arr[i + 1] = arr[fin]; 
        // 1 asignación, 1 acceso
        arr[fin] = temp; 

        // 1 retorno, 1 suma
        return i + 1; 

        /*
         * ANALISIS DE COMPLEJIDAD (Método partición)
         * Expresión algebraica aproximada del ciclo: f(n) = 3 + 3n + 5n(en el if) + 9 = 8n + 12 operaciones.
         * * NOTACIÓN ASINTÓTICA:
         * El método de partición recorre el subarreglo de tamaño n una vez, por lo que su complejidad es lineal O(n).
         * Dado que QuickSort divide el arreglo recursivamente (idealmente a la mitad), la profundidad del árbol 
         * de recursión es log(n). Por lo tanto, al multiplicar la partición por la profundidad, obtenemos:
         * Caso Promedio / Mejor Caso: O(n log n).
         * Peor Caso: O(n^2) (ocurre si el arreglo ya está ordenado y siempre se elige el último elemento como pivote).
         */
    }
}
