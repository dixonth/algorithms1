import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// -------------------------------------------------------------------------

/**
 *  This class contains static methods that implementing sorting of an array of numbers
 *  using different sort algorithms.
 *
 *  @author
 *  @version HT 2020
 */

 class SortComparison {

    /**
     * Sorts an array of doubles using InsertionSort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order.
     *
     */
    static double [] insertionSort (double a[]){
    	if (a ==null) return null;
    	int n = a.length; 
        for (int i = 1; i < n; ++i) { 
            double key = a[i]; 
            int j = i - 1;

            while (j >= 0 && a[j] > key) { 
                a[j + 1] = a[j]; 
                j = j - 1; 
            } 
            a[j + 1] = key; 
        } 
        return a;
    }//end insertionsort
	
	    /**
     * Sorts an array of doubles using Selection Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     *
     */
    static double [] selectionSort (double a[]){
    	if (a ==null) return null;
    	int n = a.length; 
    	  
        for (int i = 0; i < n-1; i++) 
        { 
            int min_idx = i; 
            for (int j = i+1; j < n; j++) 
                if (a[j] < a[min_idx]) 
                    min_idx = j; 
  
            double temp = a[min_idx]; 
            a[min_idx] = a[i]; 
            a[i] = temp; 
        } 
        return a;
    }//end selectionsort

    /**
     * Sorts an array of doubles using Quick Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     *
     */
    static double [] quickSort (double a[]){
    	if (a ==null) return null;
		qSort(a, 0, a.length-1);
		return a;

    }//end quicksort
    
    static int partition(double a[], int low, int high) 
    { 
        double pivot = a[high];  
        int i = (low-1); 
        for (int j=low; j<high; j++) 
        { 
            if (a[j] < pivot) 
            { 
                i++; 
  
                double temp = a[i]; 
                a[i] = a[j]; 
                a[j] = temp; 
            } 
        } 
  
        double temp = a[i+1]; 
        a[i+1] = a[high]; 
        a[high] = temp; 
  
        return i+1; 
    } 
  
  
    /* The main function that implements QuickSort() 
      a[] --> array to be sorted, 
      low  --> Starting index, 
      high  --> Ending index */
    static void qSort(double a[], int low, int high) 
    { 
        if (low < high) 
        { 
            int pi = partition(a, low, high); 
  
            qSort(a, low, pi-1); 
            qSort(a, pi+1, high); 
        } 
    } 

    /**
     * Sorts an array of doubles using Merge Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     *
     */
    /**
     * Sorts an array of doubles using iterative implementation of Merge Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     *
     * @param a: An unsorted array of doubles.
     * @return after the method returns, the array must be in ascending sorted order.
     */

    static double[] mergeSortIterative (double a[]) {
    	if (a ==null) return null;
    	int n =a.length;
        int curr_size;  
        int left_start; 
                          
          
        for (curr_size = 1; curr_size <= n-1;  
                      curr_size = 2*curr_size) 
        { 
            for (left_start = 0; left_start < n-1; 
                        left_start += 2*curr_size) 
            { 
                int mid = Math.min(left_start + curr_size - 1, n-1); 
          
                int right_end = Math.min(left_start  
                             + 2*curr_size - 1, n-1); 
          
                merge(a, left_start, mid, right_end); 
            } 
        } 
        return a;
    }//end mergesortIterative
    
    static void merge(double a[], int l, int m, int r) 
    { 
        int i, j, k; 
        int n1 = m - l + 1; 
        int n2 = r - m; 
      
        double L[] = new double[n1]; 
        double R[] = new double[n2]; 
      
        for (i = 0; i < n1; i++) 
            L[i] = a[l + i]; 
        for (j = 0; j < n2; j++) 
            R[j] = a[m + 1+ j]; 
      
        i = 0; 
        j = 0; 
        k = l; 
        while (i < n1 && j < n2) 
        { 
            if (L[i] <= R[j]) 
            { 
                a[k] = L[i]; 
                i++; 
            } 
            else
            { 
                a[k] = R[j]; 
                j++; 
            } 
            k++; 
        } 
      
        while (i < n1) 
        { 
            a[k] = L[i]; 
            i++; 
            k++; 
        } 
      
        while (j < n2) 
        { 
            a[k] = R[j]; 
            j++; 
            k++; 
        } 
    } 
    
    
    /**
     * Sorts an array of doubles using recursive implementation of Merge Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     *
     * @param a: An unsorted array of doubles.
     * @return after the method returns, the array must be in ascending sorted order.
     */
    static double[] mergeSortRecursive (double a[]) {
    	if(a == null) 
        { 
            return a; 
        } 
    	
    	if(a.length > 1) 
        { 
            int mid = a.length / 2; 
  
            double[] left = new double[mid]; 
            for(int i = 0; i < mid; i++) 
            { 
                left[i] = a[i]; 
            } 
              
            double[] right = new double[a.length - mid]; 
            for(int i = mid; i < a.length; i++) 
            { 
                right[i - mid] = a[i]; 
            } 
            mergeSortRecursive(left); 
            mergeSortRecursive(right); 
  
            int i = 0; 
            int j = 0; 
            int k = 0; 
  
            while(i < left.length && j < right.length) 
            { 
                if(left[i] < right[j]) 
                { 
                    a[k] = left[i]; 
                    i++; 
                } 
                else
                { 
                    a[k] = right[j]; 
                    j++; 
                } 
                k++; 
            } 
            while(i < left.length) 
            { 
                a[k] = left[i]; 
                i++; 
                k++; 
            } 
            while(j < right.length) 
            { 
                a[k] = right[j]; 
                j++; 
                k++; 
            } 
        } 
    	return a;
   }//end mergeSortRecursive
    	
    


   


    public static void main(String[] args) throws NumberFormatException, IOException {
    	File myfile = new File("numbers10.txt"); 
    	BufferedReader abc = new BufferedReader(new FileReader(myfile));
    	List<Double> data = new ArrayList<Double>();
    	String s;
    	Double d;
    	while((s=abc.readLine())!=null) {
    		d = Double.valueOf(s);
    	    data.add(d);
    	    System.out.println(s);
    	}
    	abc.close();
    	
    	double[] a = new double[data.size()];
    	a = data.toArray(a);
    	
    	insertionSort(a);
    }

 }//end class
