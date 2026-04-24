package problem2;

public class Producer implements Runnable {

    private SharedResource resource;

    public Producer(SharedResource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            resource.set(i);
            System.out.println("Produced: " + i);
        }
    }
}