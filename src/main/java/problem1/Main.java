package problem1;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		int cores = Runtime.getRuntime().availableProcessors();

		System.out.println("Cores: " + cores);
		
		runTest(1);
		runTest(cores);

	}

	public static void runTest(int threadCount) throws InterruptedException {

		long startTime = System.currentTimeMillis();

		Thread[] th = new Thread[threadCount];

		long total = 10_000_000;
		long chunkSize = total / threadCount;

		for (int i = 0; i < threadCount; i++) {
			long start = i * chunkSize;
			long end = (i == threadCount - 1) ? total : start + chunkSize;
			
			th[i] = new Thread(new MathTask(start,end));
			th[i].start();
		}
		
		for ( Thread t : th) {
			t.join();
		}
		
		long endTime = System.currentTimeMillis();
		System.out.println(threadCount + " threads took: "+ (endTime - startTime) + "ms");
	}

}
