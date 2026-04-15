package com.mycompany.ordenamientos;

import java.util.Arrays;

/**
 *
 * @author Emmanuel Riveros
 */
public class Ordenamientos {

    public static void main(String[] args) {
        Ordenamientos ordenador = new Ordenamientos();
        
        // Prueba QuickSort
        //int[] arregloQuick = {8, 3, 1, 7, 0, 10, 2};
        //System.out.println("--- Prueba QuickSort ---");
        //System.out.println("Original: " + Arrays.toString(arregloQuick));
        //ordenador.quickSort(arregloQuick, 0, arregloQuick.length - 1);
        //System.out.println("Ordenado: " + Arrays.toString(arregloQuick));

        // Prueba Merge Sort
        int[] arregloMerge = {8, 3, 1, 7, 0, 10, 2};
        System.out.println("\n--- Prueba Merge Sort ---");
        System.out.println("Original: " + Arrays.toString(arregloMerge));
        ordenador.mergeSort(arregloMerge, 0, arregloMerge.length - 1);
        System.out.println("Ordenado: " + Arrays.toString(arregloMerge));
    }

    // --- MÉTODOS DE QUICKSORT (Ya los tenías) ---
    public void quickSort(int[] arr, int inicio, int fin) {
        if (inicio < fin) {
            int indicePivote = particion(arr, inicio, fin);
            quickSort(arr, inicio, indicePivote - 1);
            quickSort(arr, indicePivote + 1, fin);
        }
    }

    private int particion(int[] arr, int inicio, int fin) {
        int pivote = arr[fin];
        int i = (inicio - 1);
        for (int j = inicio; j < fin; j++) {
            if (arr[j] <= pivote) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[fin];
        arr[fin] = temp;
        return i + 1;
    }

    // --- NUEVOS MÉTODOS: MERGE SORT ---

    // Método principal de Merge Sort
    public void mergeSort(int[] arr, int izquierda, int derecha) {
        // 1 comparación (izq < der)
        if (izquierda < derecha) {
            // 1 asignación, 3 operaciones aritméticas (punto medio)
            int medio = izquierda + (derecha - izquierda) / 2;

            // 1 llamada a método (división izquierda)
            mergeSort(arr, izquierda, medio);
            
            // 1 llamada a método, 1 suma (división derecha)
            mergeSort(arr, medio + 1, derecha);

            // 1 llamada a método (proceso de mezcla)
            merge(arr, izquierda, medio, derecha);
        }
    }

    // Método auxiliar para mezclar (Merge)
    private void merge(int[] arr, int izq, int medio, int der) {
        // Cálculo de tamaños: 2 asignaciones, 2 restas, 1 suma
        int n1 = medio - izq + 1;
        int n2 = der - medio;

        // Creación de arreglos temporales
        int[] L = new int[n1];
        int[] R = new int[n2];

        // Copia de datos a arreglos temporales: n operaciones
        for (int i = 0; i < n1; ++i) {
            L[i] = arr[izq + i];      
        }
        for (int j = 0; j < n2; ++j) { 
            R[j] = arr[medio + 1 + j]; 
        }

        int i = 0, j = 0;
        int k = izq;

        // Proceso de mezcla: n comparaciones y asignaciones
        while (i < n1 && j < n2) {  
            if (L[i] <= R[j]) {      
                arr[k] = L[i];       
                i++;                 
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        // Copiar elementos restantes de L[] si los hay
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        // Copiar elementos restantes de R[] si los hay
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }

        
    }
}