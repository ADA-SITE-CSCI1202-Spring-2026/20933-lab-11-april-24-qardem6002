package problem2;

public class SharedResource {
	private int value;
	private boolean bChanged;

	public synchronized void set(int value) {
		try {
			while (bChanged) {
				wait();
			}

			this.value = value;
			bChanged = true;
			
			notifyAll();
		} catch (InterruptedException e) {
			e.printStackTrace();

		}
	}

	public synchronized int get() {
		try {
			while (!bChanged) {
				wait();
			}

			bChanged = false;
			notifyAll();

			return value;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return -1;
	}
}
