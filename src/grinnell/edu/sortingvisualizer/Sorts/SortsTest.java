package grinnell.edu.sortingvisualizer.Sorts;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import grinnell.edu.sortingvisualizer.events.SortEvent;

public class SortsTest {
	/**
	 * 
	 * @param takes an array of generic type
	 * @return true if array is sorted
	 */
	public <T extends Comparable<T>> boolean isSorted(T[] arr){
		for(int i = 0; i < arr.length-1; i++){
			if(arr[i].compareTo(arr[i+1]) > 0){
				return false;
			}
		}
		return true;
	}
	
	@Test
	public void testSelectionSort() {
		Integer[] arr1 ={};
		Integer[] arr2= {1, -15, 11, 10000, 15, 21};
		Integer[] arr3= {3,-10,4,2,6,4,8,4,100,-99};
		String[] arr4 ={"abc","add","deg","askrhf","quakd","za","xgj"," "};
		Double[] arr5 = {1.22, 4.55, 6.12, 3.11,2.32,-1.34};
		
		List<SortEvent<Integer>> l1 = Sorts.selectionSort(Arrays.copyOf(arr1, arr1.length));
		List<SortEvent<Integer>> l2 = Sorts.selectionSort(Arrays.copyOf(arr2, arr2.length));
		List<SortEvent<Integer>> l3 = Sorts.selectionSort(Arrays.copyOf(arr3, arr3.length));
		List<SortEvent<String>> l4 = Sorts.selectionSort(Arrays.copyOf(arr4, arr4.length));
		List<SortEvent<Double>> l5 = Sorts.selectionSort(Arrays.copyOf(arr5, arr5.length));
		
		Sorts.eventSort(arr1, l1);
		Sorts.eventSort(arr2, l2);
		Sorts.eventSort(arr3, l3);
		Sorts.eventSort(arr4, l4);
		Sorts.eventSort(arr5, l5);
		
		assertEquals(true, isSorted(arr1));
		assertEquals(true, isSorted(arr2));
		assertEquals(true, isSorted(arr3));
		assertEquals(true, isSorted(arr4));
		assertEquals(true, isSorted(arr5));
	}
	
	@Test
	public void testInsertionSort() {
		Integer[] arr1 ={};
		Integer[] arr2= {1, -15, 11, 10000, 15, 21};
		Integer[] arr3= {3,-10,4,2,6,4,8,4,100,-99};
		String[] arr4 ={"abc","add","deg","askrhf","quakd","za","xgj"," "};
		Double[] arr5 = {1.22, 4.55, 6.12, 3.11,2.32,-1.34};
		
		List<SortEvent<Integer>> l1 = Sorts.insertionSort(Arrays.copyOf(arr1, arr1.length));
		List<SortEvent<Integer>> l2 = Sorts.insertionSort(Arrays.copyOf(arr2, arr2.length));
		List<SortEvent<Integer>> l3 = Sorts.insertionSort(Arrays.copyOf(arr3, arr3.length));
		List<SortEvent<String>> l4 = Sorts.insertionSort(Arrays.copyOf(arr4, arr4.length));
		List<SortEvent<Double>> l5 = Sorts.insertionSort(Arrays.copyOf(arr5, arr5.length));
		
		Sorts.eventSort(arr1, l1);
		Sorts.eventSort(arr2, l2);
		Sorts.eventSort(arr3, l3);
		Sorts.eventSort(arr4, l4);
		Sorts.eventSort(arr5, l5);
		
		assertEquals(true, isSorted(arr1));
		assertEquals(true, isSorted(arr2));
		assertEquals(true, isSorted(arr3));
		assertEquals(true, isSorted(arr4));
		assertEquals(true, isSorted(arr5));
	}
	
	@Test
	public void testBubbleSort() {
		Integer[] arr1 ={};
		Integer[] arr2= {1, -15, 11, 10000, 15, 21};
		Integer[] arr3= {3,-10,4,2,6,4,8,4,100,-99};
		String[] arr4 ={"abc","add","deg","askrhf","quakd","za","xgj"," "};
		Double[] arr5 = {1.22, 4.55, 6.12, 3.11,2.32,-1.34};
		
		List<SortEvent<Integer>> l1 = Sorts.bubbleSort(Arrays.copyOf(arr1, arr1.length));
		List<SortEvent<Integer>> l2 = Sorts.bubbleSort(Arrays.copyOf(arr2, arr2.length));
		List<SortEvent<Integer>> l3 = Sorts.bubbleSort(Arrays.copyOf(arr3, arr3.length));
		List<SortEvent<String>> l4 = Sorts.bubbleSort(Arrays.copyOf(arr4, arr4.length));
		List<SortEvent<Double>> l5 = Sorts.bubbleSort(Arrays.copyOf(arr5, arr5.length));
		
		Sorts.eventSort(arr1, l1);
		Sorts.eventSort(arr2, l2);
		Sorts.eventSort(arr3, l3);
		Sorts.eventSort(arr4, l4);
		Sorts.eventSort(arr5, l5);
		
		assertEquals(true, isSorted(arr1));
		assertEquals(true, isSorted(arr2));
		assertEquals(true, isSorted(arr3));
		assertEquals(true, isSorted(arr4));
		assertEquals(true, isSorted(arr5));
	}
	
	@Test
	public void testMergeSort() {
		Integer[] arr1 ={};
		Integer[] arr2= {1, -15, 11, 10000, 15, 21};
		Integer[] arr3= {3,-10,4,2,6,4,8,4,100,-99};
		String[] arr4 ={"abc","add","deg","askrhf","quakd","za","xgj"," "};
		Double[] arr5 = {1.22, 4.55, 6.12, 3.11,2.32,-1.34};
		
		List<SortEvent<Integer>> l1 = Sorts.mergeSort(Arrays.copyOf(arr1, arr1.length));
		List<SortEvent<Integer>> l2 = Sorts.mergeSort(Arrays.copyOf(arr2, arr2.length));
		List<SortEvent<Integer>> l3 = Sorts.mergeSort(Arrays.copyOf(arr3, arr3.length));
		List<SortEvent<String>> l4 = Sorts.mergeSort(Arrays.copyOf(arr4, arr4.length));
		List<SortEvent<Double>> l5 = Sorts.mergeSort(Arrays.copyOf(arr5, arr5.length));
		
		Sorts.eventSort(arr1, l1);
		Sorts.eventSort(arr2, l2);
		Sorts.eventSort(arr3, l3);
		Sorts.eventSort(arr4, l4);
		Sorts.eventSort(arr5, l5);
		
		assertEquals(true, isSorted(arr1));
		assertEquals(true, isSorted(arr2));
		assertEquals(true, isSorted(arr3));
		assertEquals(true, isSorted(arr4));
		assertEquals(true, isSorted(arr5));
	}
	
	@Test
	public void testQuickSort() {
		Integer[] arr1 ={};
		Integer[] arr2= {1, -15, 11, 0, 15, 21};
		Integer[] arr3= {3,-10,4,2,6,4,8,4,100,-99};
		String[] arr4 ={"abc","add","deg","askrhf","quakd","za","xgj"," "};
		Double[] arr5 = {1.22, 4.55, 6.12, 3.11,2.32,-1.34};
		
		List<SortEvent<Integer>> l1 = Sorts.quickSort(Arrays.copyOf(arr1, arr1.length));
		List<SortEvent<Integer>> l2 = Sorts.quickSort(Arrays.copyOf(arr2, arr2.length));
		List<SortEvent<Integer>> l3 = Sorts.quickSort(Arrays.copyOf(arr3, arr3.length));
		List<SortEvent<String>> l4 = Sorts.quickSort(Arrays.copyOf(arr4, arr4.length));
		List<SortEvent<Double>> l5 = Sorts.quickSort(Arrays.copyOf(arr5, arr5.length));
		
		Sorts.eventSort(arr1, l1);
		Sorts.eventSort(arr2, l2);
		Sorts.eventSort(arr3, l3);
		Sorts.eventSort(arr4, l4);
		Sorts.eventSort(arr5, l5);
		
		assertEquals(true, isSorted(arr1));
		assertEquals(true, isSorted(arr2));
		assertEquals(true, isSorted(arr3));
		assertEquals(true, isSorted(arr4));
		assertEquals(true, isSorted(arr5));
	}

}
