import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;

public class CallCenter {
    private static final int CALLS = 8;
    private static final Queue<String> phoneCalls = new ArrayBlockingQueue<>(CALLS);
    private static final int PAUSE = 1000;
    public static final int ANSWER = 3000;

    public void call(){
        phoneCalls.offer(Thread.currentThread().getName());
        try {
            Thread.sleep(PAUSE);
            System.out.println(Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void takeTheCall(){
        Random random = new Random();
        while (!phoneCalls.isEmpty()) {
            try {
                Thread.sleep(ANSWER);
                System.out.println(Thread.currentThread().getName() + " ответил на " + phoneCalls.poll());
                Thread.sleep(ANSWER + random.nextInt(5 * PAUSE));
                System.out.println(Thread.currentThread().getName() + " освободился");
                Thread.sleep(ANSWER);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
