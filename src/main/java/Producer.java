import java.util.concurrent.BlockingQueue;

/**
 * The type Producer.
 */
public class Producer implements Runnable {
    /**
     * The Queue.
     */
    static BlockingQueue<String> queue;

    /**
     * Instantiates a new Producer.
     *
     * @param queue2 the queue 2
     */
    public Producer(BlockingQueue<String> queue2) {
        queue = queue2;
    }
    public void run() {
            forMethod(2015214094,2015219000);
//            forMethod(2015210000,2015219000);
//            forMethod(2016210000,2016219000);
//            forMethod(2017210000,2017219000);
        java.awt.Toolkit.getDefaultToolkit().beep();
    }

    /**
     * For method.
     *
     * @param ii the ii
     * @param k  the k
     */
    public void forMethod(int ii,int k){
        for (int i=ii;i<k;i++){
            String url=""+i+"";
            try {
                queue.put(url);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
