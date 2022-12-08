package interview.restart.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 模拟固定线程数的线程池导致OOM
 * 参考：https://www.jianshu.com/p/30fb0251f351
 */
public class FixedThreadPool_OOM {
    private static ExecutorService executorService = Executors.newFixedThreadPool(1);

    public static void main(String[] args) {
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            executorService.execute(new TaskFixedThreadPoolOOM());
        }
    }
}

class TaskFixedThreadPoolOOM implements Runnable {
    @Override
    public void run() {
        try {
            Thread.sleep(1000000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
