package top.ycshang.basedao.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @program: basedao-sample
 * @description:
 * @author: ycshang
 * @create: 2021-11-22 20:19
 **/
public class HisThread implements Callable<Integer> {
    public static void main(String[] args) {
        HisThread ht = new HisThread();
        FutureTask<Integer> futureTask = new FutureTask<>(ht);
        Thread thread = new Thread(futureTask, "有返回值的线程");
        thread.start();
        try {
            Integer result = futureTask.get();
            System.out.println("线程的返回值" + result);
        } catch (ExecutionException | InterruptedException e) {
            System.err.println(e.getMessage());
        }


    }

    @Override
    public Integer call() throws Exception {
        System.out.println(Thread.currentThread().getName() + "执行了,将会返回100");
        return 100;
    }
}