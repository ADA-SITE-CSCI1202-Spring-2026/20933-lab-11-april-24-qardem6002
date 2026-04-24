package problem2;

public class Consumer implements Runnable {

    private SharedResource resource;

    public Consumer(SharedResource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            int val = resource.get();
            System.out.println("Consumed: " + val);
        }
    }
}