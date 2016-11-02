package grinnell.edu.sortingvisualizer;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

import grinnell.edu.sortingvisualizer.Sorts.Sorts;
/**
 * A collection of indices into a Scale object.
 * These indices are the subject of the various sorting algorithms
 * in the program.
 */
public class NoteIndices {
	public Integer[] arr;
	private boolean[] highLight;
	/**
	 * @param n the size of the scale object that these indices map into
	 */
	public NoteIndices(int n) {
		initializeAndShuffle(n);
	}



	/**
	 * Reinitializes this collection of indices to map into a new scale object
	 * of the given size.  The collection is also shuffled to provide an
	 * initial starting point for the sorting process.
	 * @param n the size of the scale object that these indices map into
	 */
	public void initializeAndShuffle(int n) {
		this.arr = new Integer[n];
		for (int i = 0; i < n; i++){
			this.arr[i] = i;
		}
		highLight = new boolean[n];
		shuffleArray(arr);
	}

	public static void shuffleArray(Integer[] ar){
		Random rnd = ThreadLocalRandom.current();
		for (int i = ar.length - 1; i > 0; i--)
		{
			int index = rnd.nextInt(i + 1);
			int a = ar[index];
			ar[index] = ar[i];
			ar[i] = a;
		}
	}


	/** @return the indices of this NoteIndices object */
	public Integer[] getNotes() { 
		return this.arr;
	}

	/**
	 * Highlights the given index of the note array
	 * @param index the index to highlight
	 */

	public void highlightNote(int index) {
		this.highLight[index] = true;
	}

	/** @return true if the given index is highlighted */
	public boolean isHighlighted(int index) {
		return this.highLight[index];
	}

	/** Clears all highlighted indices from this collection */
	public void clearAllHighlighted() {
		for(int i = 0; i < highLight.length;i++){
			highLight[i] = false;
		}
	}
}

