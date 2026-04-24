package problem1;



public class MathTask implements Runnable {

	private long start;
	private long end;

	public MathTask(long start, long end) {
		this.start = start;
		this.end = end;
	}

	

	@Override
	public void run() {
		long result = 0;

		for (long i = start; i < end; i++) {
			result += i * i * i + i * 3;
		}
		
		if (result == Integer.MIN_VALUE) {
			System.out.println("hmmm");
		}
	}

}
