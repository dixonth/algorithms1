/*
 * 	time(ms)			Insert 		Selection 		Merge Iterative 		Merge Recursive 		Quick
 * 
10 random				.33			0				0						0						0

100 random				0			0				0						.33						.33

1000 random				3.67		.33				0						.33						.33

1000 few unique			2.33		.33				.33						0						.67

1000 nearly ordered		0			.67				0						0						1

1000 reverse order		.33			.33				.33						0						.33

1000 sorted				0			.33				0						0						1

NOTE: some of the results were not what was expected. I think the decision to time it in milliseconds was strange and a bit confusing as 
many of the values were 0, or varied hugely in my testing.

a. Which of the sorting algorithms does the order of input have an impact on? Why?
The order has an impact on the insertionSort, the run time is almost zero when nearly ordered because the algorithm only deals with values not in order.

b. Which algorithm has the biggest difference between the best and worst performance, based
on the type of input, for the input of size 1000? Why?
Insertion Sort has the biggest difference between best and worst performance as its performance improves dramatically with the nearly ordered file.

c. Which algorithm has the best/worst scalability, i.e., the difference in performance time
based on the input size? Please consider only input files with random order for this answer.
Selection sort and Insertion sort have the worst scalability.

d. Did you observe any difference between iterative and recursive implementations of merge
sort?
I observed a worse scalability in in my implementation of recursive merge sort, but all of my results were strange so I'm not sure if this holds any weight.

e. Which algorithm is the fastest for each of the 7 input files?
There were algorithms that took 0ms for each of the input files. For 1000 random mergesort iterative was fastest. For 100 few unique, mergesort recursive was fastest.
*/
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;


//-------------------------------------------------------------------------
/**
 *  Test class for SortComparison.java
 *
 *  @author
 *  @version HT 2020
 */
@RunWith(JUnit4.class)
public class SortComparisonTest
{
    //~ Constructor ........................................................
    @Test
    public void testConstructor()
    {
        new SortComparison();
    }

    //~ Public Methods ........................................................

    // ----------------------------------------------------------
    
    
    @Test
    public void insertionSort()
    {
    	double [] inArray = {4,7,1,6,3,8,2,5};
    	double [] outArray = {1,2,3,4,5,6,7,8};
    	
    	double [] emptyArray = {};
    	double [] nullArray = null;

        Assert.assertArrayEquals("insertionSort with normal array", outArray, SortComparison.insertionSort(inArray), 0);
        Assert.assertArrayEquals("insertionSort with empty array", emptyArray, SortComparison.insertionSort(emptyArray), 0);
        Assert.assertArrayEquals("insertionSort with null array", null, SortComparison.insertionSort(nullArray), 0);
    }


    @Test
    public void selectionSort()
    {
    	double [] inArray = {4,7,1,6,3,8,2,5};
    	double [] outArray = {1,2,3,4,5,6,7,8};
    	
    	double [] emptyArray = {};
    	double [] nullArray = null;

        Assert.assertArrayEquals("selectionSort with normal array", outArray, SortComparison.selectionSort(inArray), 0);
        Assert.assertArrayEquals("selectionSort with empty array", emptyArray, SortComparison.selectionSort(emptyArray), 0);
        Assert.assertArrayEquals("selectionSort with null array", null, SortComparison.selectionSort(nullArray), 0);
    }
    
    @Test
    public void quickSort()
    {
    	double [] inArray = {4,7,1,6,3,8,2,5};
    	double [] outArray = {1,2,3,4,5,6,7,8};
    	
    	double [] emptyArray = {};
    	double [] nullArray = null;

        Assert.assertArrayEquals("quickSort with normal array", outArray, SortComparison.quickSort(inArray), 0);
        Assert.assertArrayEquals("quickSort with empty array", emptyArray, SortComparison.quickSort(emptyArray), 0);
        Assert.assertArrayEquals("quickSort with null array", null, SortComparison.quickSort(nullArray), 0);
    }
    
    @Test
    public void mergeSortIterative()
    {
    	double [] inArray = {4,7,1,6,3,8,2,5};
    	double [] outArray = {1,2,3,4,5,6,7,8};
    	
    	double [] emptyArray = {};
    	double [] nullArray = null;

        Assert.assertArrayEquals("mergeSortIterative with normal array", outArray, SortComparison.mergeSortIterative(inArray), 0);
        Assert.assertArrayEquals("mergeSortIterative with empty array", emptyArray, SortComparison.mergeSortIterative(emptyArray), 0);
        Assert.assertArrayEquals("mergeSortIterative with null array", null, SortComparison.mergeSortIterative(nullArray), 0);
    }
    
    @Test
    public void mergeSortRecursive()
    {
    	double [] inArray = {4,7,1,6,3,8,2,5};
    	double [] outArray = {1,2,3,4,5,6,7,8};
    	
    	double [] emptyArray = {};
    	double [] nullArray = null;

        Assert.assertArrayEquals("mergeSortRecursive with normal array", outArray, SortComparison.mergeSortRecursive(inArray), 0);
        Assert.assertArrayEquals("mergeSortRecursive with empty array", emptyArray, SortComparison.mergeSortRecursive(emptyArray), 0);
        Assert.assertArrayEquals("mergeSortRecursive with null array", null, SortComparison.mergeSortRecursive(nullArray), 0);
    }
    
    
    /**
     *  Main Method.
     *  Use this main method to create the experiments needed to answer the experimental performance questions of this assignment.
     *
     */
    
    
    public static void main(String[] args) throws NumberFormatException, IOException {
    	String[] fileNames = new String[7];
    	fileNames[0] = "numbers10.txt";
    	fileNames[1] = "numbers100.txt";
    	fileNames[2] = "numbers1000.txt";
    	fileNames[3] = "numbers1000Duplicates.txt";
    	fileNames[4] = "numbersNearlyOrdered1000.txt";
    	fileNames[5] = "numbersReverse1000.txt";
    	fileNames[6] = "numbersSorted1000.txt";
    	
    	for (int j=0; j<7; j++) {
	    	String inputFile=fileNames[j];
	    	String intValue = inputFile.replaceAll("[^0-9]", "");
	    	int fileLength = Integer.parseInt(intValue);
	    	File myfile = new File(inputFile); 
	    	BufferedReader abc = new BufferedReader(new FileReader(myfile));
	    	double [] data = new double[fileLength];
	    	String s;
	    	Double d;
	    	for (int i=0;i<fileLength; i++) {
	    		s=abc.readLine();
	    		d = Double.valueOf(s);
	    	    data[i] = d;
	    	}
	    	abc.close();
	    	
	    	
	    	long startTime = System.nanoTime();
	    	SortComparison.insertionSort(data);
	    	long endTime = System.nanoTime();
	    	long duration = (endTime - startTime)/1000000;
	    	System.out.println("Time taken in for insert("+fileNames[j]+")txt:"+duration);
	    	
	    	startTime = System.nanoTime();
	    	SortComparison.selectionSort(data);
	    	endTime = System.nanoTime();
	    	duration = (endTime - startTime)/1000000;
	    	System.out.println("Time taken in for select("+fileNames[j]+")txt:"+duration);
	    	
	    	startTime = System.nanoTime();
	    	SortComparison.mergeSortIterative(data);
	    	endTime = System.nanoTime();
	    	duration = (endTime - startTime)/1000000;
	    	System.out.println("Time taken in for merge iter("+fileNames[j]+")txt:"+duration);
	    	
	    	startTime = System.nanoTime();
	    	SortComparison.mergeSortRecursive(data);
	    	endTime = System.nanoTime();
	    	duration = (endTime - startTime)/1000000;
	    	System.out.println("Time taken in for merge rec("+fileNames[j]+")txt:"+duration);
	    	
	    	startTime = System.nanoTime();
	    	SortComparison.quickSort(data);
	    	endTime = System.nanoTime();
	    	duration = (endTime - startTime)/1000000;
	    	System.out.println("Time taken in for quick("+fileNames[j]+")txt:"+duration);
	    	
	    	
    	}
    	
    }

}
