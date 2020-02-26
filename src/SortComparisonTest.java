/*
 * 	time(ms)			Insert 		Selection 		Merge Recursive 		Merge Iterative 		Quick
 * 
10 random				3			0				0						0						0

100 random				0			0				0						.33						.33

1000 random				3.67		3				0						.33						.33

1000 few unique			2.33		.33				.33						0						.67

1000 nearly ordered		0			.67				0						0						1

1000 reverse order		.33			.33				.33						0						.33

1000 sorted				0			.33				0						0						1
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
	    	endTime = endTime/1000000;
	    	startTime = startTime/1000000;
	    	long duration = (endTime - startTime);
	    	System.out.println("Time taken in for insert("+data.length+")txt:"+duration);
	    	
	    	startTime = System.nanoTime();
	    	SortComparison.selectionSort(data);
	    	endTime = System.nanoTime();
	    	endTime = endTime/1000000;
	    	startTime = startTime/1000000;
	    	duration = (endTime - startTime);
	    	System.out.println("Time taken in for select("+data.length+")txt:"+duration);
	    	
	    	startTime = System.nanoTime();
	    	SortComparison.mergeSortIterative(data);
	    	endTime = System.nanoTime();
	    	endTime = endTime/1000000;
	    	startTime = startTime/1000000;
	    	duration = (endTime - startTime);
	    	System.out.println("Time taken in for merge iter("+data.length+")txt:"+duration);
	    	
	    	startTime = System.nanoTime();
	    	SortComparison.mergeSortRecursive(data);
	    	endTime = System.nanoTime();
	    	endTime = endTime/1000000;
	    	startTime = startTime/1000000;
	    	duration = (endTime - startTime);
	    	System.out.println("Time taken in for merge rec("+data.length+")txt:"+duration);
	    	
	    	startTime = System.nanoTime();
	    	SortComparison.quickSort(data);
	    	endTime = System.nanoTime();
	    	endTime = endTime/1000000;
	    	startTime = startTime/1000000;
	    	duration = (endTime - startTime);
	    	System.out.println("Time taken in for quick("+data.length+")txt:"+duration);
	    	
	    	
    	}
    	
    }

}
