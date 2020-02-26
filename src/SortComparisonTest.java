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
    public static void main(String[] args)
    {
        //TODO: implement this method
    }

}
