import java.util.LinkedList;


public class Main {
	public static void main(String[] args) {
		final int MOD_BASE = 5;
		final int[] COEFF = {1,4,1,4};
		//final int[] COEFF = {1,0,0,1};
		final int K = 3;
		final int[] START_VALUES = {1,4,2,1};
		
		LinkedList<Integer> list = new LinkedList<Integer>();
		for (int i = 0; i < COEFF.length; i++) {
			list.add(START_VALUES[i]);
		}
		
		@SuppressWarnings("unchecked")
		final LinkedList<Integer> START = (LinkedList<Integer>) list.clone();
		
		int count = 0;
		print(count, list);
		do {
			count++;
			int sum = K;
			for (int i = 0; i < COEFF.length; i++) {
				sum += COEFF[i]*list.get(i);
			}
			
			list.addFirst(sum % MOD_BASE);
			list.removeLast();
			print(count, list);
		} while (list.hashCode() != START.hashCode());
	}

	private static void print(int count, LinkedList<Integer> list) {
		System.out.print(count + ":\t");
		for (int nbr : list) {
			System.out.print(nbr);
		}
		System.out.println();
	}
}
