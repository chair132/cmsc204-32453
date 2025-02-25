
public class ArraySum {

	public int sumOfArray(Integer[] a) {
		return sumOfArray(a, a.length - 1);
	}
	
	public int sumOfArray(Integer[] a, int index) {
		if (index <= 0) {
			return a[index];
		} else {
			return a[index] + sumOfArray(a, index - 1);
		}
	}
}
