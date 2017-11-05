import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.BlockingQueue;
/**
 * The type Consumer.
 */
public class Consumer implements Runnable {
    /**
     * Instantiates a new Consumer.
     *
     * @param queue2 the queue 2
     */
    public Consumer(BlockingQueue<String> queue2) {
        queue = queue2;
    }
    private static final String saveImgPath="E://imgs";
    /**
     * The Queue.
     */
    static BlockingQueue<String> queue;
    //图片保存路径
    @Override
    public void run() {
        while (!queue.isEmpty()) {
            String id = null;
            try {
                id = queue.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            StringBuffer PRE = new StringBuffer("http://jwzx.cqupt.edu.cn/showstuPic.php?xh=");
            StringBuffer ul = PRE.append(id);
            String name = id + ".jpg";
            try {
                URL  url = new URL(ul.toString());
                URLConnection uri = url.openConnection();
                //获取数据流
                InputStream is = uri.getInputStream();
                System.out.println(is.available()+" "+Thread.currentThread().getName());
                if (is.available() < 3208) {
                    continue;
                }
                //写入数据流
                OutputStream os = new FileOutputStream(new File(saveImgPath, name));
                byte[] buf = new byte[1024];
                int l = 0;
                while ((l = is.read(buf)) != -1) {
                    os.write(buf, 0, l);
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}