
public class PrimeNumberAdvanced {
	
	public static boolean[] allPrimeNumbers(int n) {
		boolean sifter[] = new boolean[n + 1];
		for (int i = 1; i <= (n + 1)/2; i++) {
				sifter[2 * i - 1] = true;
		}
		sifter[1] = false;
		sifter[2] = true;
		
		for (int i = 3; i <= Math.sqrt(n); i++) {
			if (sifter[i]) {
				for (int j = i; j * i <= n; j+=2)
					sifter[j * i] = false;
			}
		}
		
		return sifter;
	}
	
	public static void main(String[] args) {
		try {
			if (args.length != 2)
				throw new IllegalArgumentException();
			int m = Integer.parseInt(args[0]);
			int n = Integer.parseInt(args[1]);
			
			boolean sifter[] = allPrimeNumbers(n);
			int counter = 0;
			for (int i = m; i <= n; i++) {
				if (sifter[i]) {
					System.out.print(i + " ");
					counter++;
				}
				
				if (counter == 10) {
					System.out.println();
					counter = 0;
				}
			}
			
		} catch (IllegalArgumentException exc) {
			System.out.println("Please give two integers!");
		} 
	}

}
