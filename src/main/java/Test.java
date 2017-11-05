import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;


public class Test {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     * @throws InterruptedException the interrupted exception
     */
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String>  queue =new LinkedBlockingQueue<String>();
        Consumer consumer=new Consumer(queue);
        Producer producer =new Producer(queue);

        ExecutorService service= Executors.newFixedThreadPool(500);
        service.submit(producer);
        for (int i=0;i<300;i++) {
            service.submit(consumer);
        }
    }
}
