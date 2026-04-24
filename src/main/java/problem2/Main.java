package problem2;

public class Main {

    public static void main(String[] args) {

        SharedResource resource = new SharedResource();

        Thread producer = new Thread(new Producer(resource));
        Thread consumer = new Thread(new Consumer(resource));

        producer.start();
        consumer.start();
    }
}