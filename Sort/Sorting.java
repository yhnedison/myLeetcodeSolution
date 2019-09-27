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

    public static void mergeSort(int[] arr, int l, int r) {
        /**
         * O(nlogn) O(n)
         */
        if (l < r) {
            int m = l + (r-l)/2;
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);
            merge(arr, l , m , r);
        }
    }
    private static void merge(int arr[], int l, int m, int r) { 
        int i, j, k; 
        int n1 = m - l + 1; 
        int n2 =  r - m; 
    
        /* create temp arrays */
        int L[n1], R[n2]; 
    
        /* Copy data to temp arrays L[] and R[] */
        for (i = 0; i < n1; i++) 
            L[i] = arr[l + i]; 
        for (j = 0; j < n2; j++) 
            R[j] = arr[m + 1+ j]; 
    
        /* Merge the temp arrays back into arr[l..r]*/
        i = 0; // Initial index of first subarray 
        j = 0; // Initial index of second subarray 
        k = l; // Initial index of merged subarray 
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
    
        /* Copy the remaining elements of L[], if there 
        are any */
        while (i < n1) { 
            arr[k] = L[i]; 
            i++; 
            k++; 
        } 
    
        /* Copy the remaining elements of R[], if there 
        are any */
        while (j < n2) { 
            arr[k] = R[j]; 
            j++; 
            k++; 
        } 
    } 


}