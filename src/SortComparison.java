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
            /* Move elements of a[0..i-1], that are 
               greater than key, to one position ahead 
               of their current position */
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
    	  
        // One by one move boundary of unsorted subarray 
        for (int i = 0; i < n-1; i++) 
        { 
            // Find the minimum element in unsorted array 
            int min_idx = i; 
            for (int j = i+1; j < n; j++) 
                if (a[j] < a[min_idx]) 
                    min_idx = j; 
  
            // Swap the found minimum element with the first 
            // element 
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
		 //todo: implement the sort

    }//end quicksort
    
    static int partition(double a[], int low, int high) 
    { 
        double pivot = a[high];  
        int i = (low-1); // index of smaller element 
        for (int j=low; j<high; j++) 
        { 
            // If current element is smaller than the pivot 
            if (a[j] < pivot) 
            { 
                i++; 
  
                // swap a[i] and a[j] 
                double temp = a[i]; 
                a[i] = a[j]; 
                a[j] = temp; 
            } 
        } 
  
        // swap a[i+1] and a[high] (or pivot) 
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
            /* pi is partitioning index, a[pi] is  
              now at right place */
            int pi = partition(a, low, high); 
  
            // Recursively sort elements before 
            // partition and after partition 
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
    	// For current size of subarrays to 
        // be merged curr_size varies from  
        // 1 to n/2 
    	int n =a.length;
        int curr_size;  
                      
        // For picking starting index of  
        // left subarray to be merged 
        int left_start; 
                          
          
        // Merge subarrays in bottom up  
        // manner. First merge subarrays  
        // of size 1 to create sorted  
        // subarrays of size 2, then merge 
        // subarrays of size 2 to create  
        // sorted subarrays of size 4, and 
        // so on. 
        for (curr_size = 1; curr_size <= n-1;  
                      curr_size = 2*curr_size) 
        { 
              
            // Pick starting point of different 
            // subarrays of current size 
            for (left_start = 0; left_start < n-1; 
                        left_start += 2*curr_size) 
            { 
                // Find ending point of left  
                // subarray. mid+1 is starting  
                // point of right 
                int mid = Math.min(left_start + curr_size - 1, n-1); 
          
                int right_end = Math.min(left_start  
                             + 2*curr_size - 1, n-1); 
          
                // Merge Subarrays arr[left_start...mid] 
                // & arr[mid+1...right_end] 
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
      
        /* create temp arrays */
        double L[] = new double[n1]; 
        double R[] = new double[n2]; 
      
        /* Copy data to temp arrays L[] 
        and R[] */
        for (i = 0; i < n1; i++) 
            L[i] = a[l + i]; 
        for (j = 0; j < n2; j++) 
            R[j] = a[m + 1+ j]; 
      
        /* Merge the temp arrays back into 
        arr[l..r]*/
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
      
        /* Copy the remaining elements of  
        L[], if there are any */
        while (i < n1) 
        { 
            a[k] = L[i]; 
            i++; 
            k++; 
        } 
      
        /* Copy the remaining elements of 
        R[], if there are any */
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
  
            // Split left part 
            double[] left = new double[mid]; 
            for(int i = 0; i < mid; i++) 
            { 
                left[i] = a[i]; 
            } 
              
            // Split right part 
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
  
            // Merge left and right arrays 
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
            // Collect remaining elements 
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
    	
    


   


//    public static void main(String[] args) {
//        //todo: do experiments as per assignment instructions
//    }

 }//end class
