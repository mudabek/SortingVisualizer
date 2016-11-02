package grinnell.edu.sortingvisualizer.events;

import java.util.ArrayList;
import java.util.List;

public class CompareEvent<T> implements SortEvent<T>{
	public int index1;
	public int index2;

	public CompareEvent (int a, int b){
		index1 = a;
		index2 = b;
	}
	public void apply(T[] arr) {
	}

	@Override
	public List<Integer> getAffectedIndices() {
		List<Integer> ret = new ArrayList<Integer>();
		ret.add(this.index1);
		ret.add(this.index2);
		return ret;
	}

	@Override
	public boolean isEmphasized() {
		return false;
	}

}
