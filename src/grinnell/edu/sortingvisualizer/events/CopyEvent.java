package grinnell.edu.sortingvisualizer.events;

import java.util.ArrayList;
import java.util.List;

public class CopyEvent<T> implements SortEvent<T>{
	public T val;
	public int index;
	
	public CopyEvent (T v, int a){
		val = v;
		index = a;
	}
	public void apply(T[] arr) {
		arr[index] = val;
	}

	@Override
	public List<Integer> getAffectedIndices() {
		List<Integer> ret = new ArrayList<Integer>();
		ret.add(this.index);
		return ret;
	}

	@Override
	public boolean isEmphasized() {
		return true;
	}

}
