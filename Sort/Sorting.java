package Sort;

/**
 * Terminology:
 *  Inplace:
 *      Use O(1) (constant) memory, e.g. Insertion Sort and Selection Sort vs Merge Sort
 *  Internal vs External:
 *      All datra is placed in memory or not. Merge Sort is external
 *  Stable: 
 *      Two object with equal keys appres in the same order in output as they appear in  input
 */

/* 
                        Best        Average     Worst	
    Selection Sort	    Ω(n^2)	    θ(n^2)	    O(n^2)
    Bubble Sort     	Ω(n)	    θ(n^2)	    O(n^2)
    Insertion Sort	    Ω(n)	    θ(n^2)	    O(n^2)
    Heap Sort	        Ω(nlog(n))	θ(nlog(n))	O(nlog(n))
    Quick Sort	        Ω(nlog(n))	θ(nlog(n))	O(n^2)
    Merge Sort	        Ω(nlog(n))	θ(nlog(n))	O(nlog(n))
    Bucket Sort	        Ω(n+k)	    θ(n+k)	    O(n^2)
    Radix Sort	        Ω(nk)	    θ(nk)	    O(nk)
 */
class Sorting {

    public static void selectionSort(int[] arr) {
        /**
         * O(n^2) O(1) 
         * Inplace, Not Stable
         * The good thing about selection sort is it never makes more than O(n) swaps and can be useful when memory write is a costly operation.
         */
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) minIndex = j;
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }
    public static void selectionSortStable(int[] arr) {
        /**
         * O(n^2) O(1) 
         * Swapping makes it unstable
         * Instead of swapping, insert min value and push all following element 
         */
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) minIndex = j;
            }
            
            int minValue = arr[minIndex];
            while (minIndex > i) {
                arr[minIndex]  = arr[minIndex - 1];
                minIndex--;
            }
            arr[i] = minValue;
        }
    }


    public static void insertionSort(int[] arr) {
        /**
         * O(n^2) O(1)
         * Inplace, Stable
         * Similar to selection sort. Every time, pick arr[i] and insert into the sorted sequence before i
         */ 
        for (int i = 1; i < arr.length; i++) {
            int j = i - 1;
            int value = arr[i];
            while (j >= 0 || arr[j] > value) {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = value;
        }
    }


    public static void bubbleSort(int[] arr) {
        /**
         * O(n^2) O(1) 
         * Inplace, Stable
         * Best case O(n) when already sorted
         */
        boolean swapped; // optimized
        for (int i = 0; i < arr.length - 1; i++) {
            swapped = false;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j+1]) {
                    // swap
                    int temp = arr[j]; 
                    arr[j] = arr[j+1]; 
                    arr[j+1] = temp; 
                    swapped = true;
                }
            }

            if (swapped == false) break;
        }
    }




}