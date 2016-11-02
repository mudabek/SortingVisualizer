package grinnell.edu.sortingvisualizer.Sorts;

import java.util.*;

import grinnell.edu.sortingvisualizer.events.CompareEvent;
import grinnell.edu.sortingvisualizer.events.CopyEvent;
import grinnell.edu.sortingvisualizer.events.SortEvent;
import grinnell.edu.sortingvisualizer.events.SwapEvent;


public class Sorts{

	public static <T extends Comparable<T>> List<SortEvent<T>> selectionSort(T[] arr){
		List<SortEvent<T>> ret = new LinkedList<SortEvent<T>>();
		for(int i = 0;i < arr.length; i++){
			int minIndex = i;
			for(int j = i; j< arr.length; j++){
				if (arr[j].compareTo(arr[minIndex]) < 0){
					minIndex = j;
					ret.add((SortEvent<T>) new CompareEvent<T>(i,j));
				}
			}		
			SortEvent<T> swap = new SwapEvent<T>(i, minIndex);
			swap.apply(arr);
			ret.add(swap);
		}
		return ret;
	}

	public static <T extends Comparable<T>> List<SortEvent<T>> insertionSort(T[] arr){
		List<SortEvent<T>> ret = new LinkedList<SortEvent<T>>();
		for(int i = 1; i < arr.length; i++){
			T temp = arr[i];
			for(int j = i-1; j >= 0; j--){
				if (temp.compareTo(arr[j]) < 0){
					ret.add((SortEvent<T>) new CompareEvent<T>(i,j));
					SortEvent<T> cp = new CopyEvent<T>(arr[j],j+1);
					cp.apply(arr);
					ret.add(cp);
					SortEvent<T> cp2 = new CopyEvent<T>(temp,j);
					cp2.apply(arr);
					ret.add(cp2);
				}
			}
		}
		return ret;
	}



	public static <T extends Comparable<T>> List<SortEvent<T>> bubbleSort(T[] arr){
		List<SortEvent<T>> ret = new LinkedList<SortEvent<T>>();
		for (int i =0; i<arr.length; i++){
			int maxIndex= i;
			for(int j = i+1; j < arr.length; j ++){
				if(arr[j].compareTo(arr[maxIndex]) < 0){
					ret.add((SortEvent<T>) new CompareEvent<T>(i,j));
					maxIndex = j;
				}
			}
			SortEvent<T> swap = new SwapEvent<T>(i,maxIndex);
			swap.apply(arr);
			ret.add(swap);
		}
		return ret;
	}


	public static <T extends Comparable<T>> void merge(T[] arr, int lo, int mid,int hi, List<SortEvent<T>> ret){
		T[] arr2 = (T[]) new Comparable[hi-lo];
		int k = 0;
		int i = lo;
		int j = mid;
		while(i < mid && j < hi){
			if( arr[i].compareTo(arr[j]) < 0){
				ret.add((SortEvent<T>) new CompareEvent<T>(i,j));
				SortEvent<T> cp1 = new CopyEvent<T>(arr[i++],k++);
				cp1.apply(arr2);
				ret.add(cp1);
			}else{
				SortEvent<T> cp2 = new CopyEvent<T>(arr[j++],k++);
				cp2.apply(arr2);
				ret.add(cp2);
			}
		}

		while(i < mid) { 
			SortEvent<T> cp3 = new CopyEvent<T>(arr[i++],k++);
			cp3.apply(arr2);
			ret.add(cp3);
		}

		while(j < hi) { 
			SortEvent<T> cp4 = new CopyEvent<T>(arr[j++],k++);
			cp4.apply(arr2);
			ret.add(cp4);
		}

		for (int m = 0; m < arr2.length; m++){
			SortEvent<T> cp5 = new CopyEvent<T>(arr2[m],lo+m);
			cp5.apply(arr);
			ret.add(cp5);
		}
	}

	public static <T extends Comparable<T>> List<SortEvent<T>> mergeSort(T[] arr){
		List<SortEvent<T>> ret = new LinkedList<SortEvent<T>>();
		mergeSortHelper(arr, 0, arr.length, ret);
		return ret;
	}

	public static <T extends Comparable<T>> void mergeSortHelper(T[] arr, int lo, int hi, List<SortEvent<T>> ret){
		if (hi-lo > 1) {
			int mid = lo + (hi - lo)/2;
			mergeSortHelper(arr, lo, mid, ret);
			mergeSortHelper(arr, mid, hi, ret);
			merge(arr, lo, mid, hi, ret);
		}
	} 

	public static <T extends Comparable<T>> List<SortEvent<T>> quickSort(T[] arr){
		List<SortEvent<T>> ret = new LinkedList<SortEvent<T>>();
		quickSortHelper(arr, 0, arr.length-1, ret);
		return ret;
	}

	public static <T extends Comparable<T>> void quickSortHelper(T[] arr,int lo, int hi, List<SortEvent<T>> ret){
		if(lo<hi){
			int P = partition(arr, lo, hi, ret);
			quickSortHelper(arr, lo, P-1, ret);
			quickSortHelper(arr, P+1, hi, ret);
		}
	}

	public static <T extends Comparable<T>> int partition(T[] arr, int lo, int hi, List<SortEvent<T>> ret){
		T P = arr[hi];
		int i = lo-1;
		for(int j=lo; j<hi; j++){
			if(arr[j].compareTo(P) < 0){
				ret.add((SortEvent<T>) new CompareEvent<T>(hi,j));
				i++;
				SortEvent<T> swap1 = new SwapEvent<T>(i,j);
				swap1.apply(arr);
				ret.add(swap1);
			}
		}
		SortEvent<T> swap2 = new SwapEvent<T>(i+1,hi);
		swap2.apply(arr);
		ret.add(swap2);
		return (i+1);
	}

	public static <T extends Comparable<T>> void eventSort(T[] arr, List<SortEvent<T>> events){
		for(int i = 0; i < events.size();i++){
			events.get(i).apply(arr);
		}
	}
}



