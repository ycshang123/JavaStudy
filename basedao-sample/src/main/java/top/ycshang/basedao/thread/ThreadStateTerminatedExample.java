package top.ycshang.basedao.thread;

/**
 * @program: basedao-sample
 * @description:
 * @author: ycshang
 * @create: 2021-11-22 23:26
 **/
public class ThreadStateTerminatedExample {
    public static void main(String[] args) {
        Runnable waiting =() ->{
            System.out.println("随便执行一下，然后线程就会变为Terminated");
        };
        Thread terminate = new Thread(waiting);
        terminate.start();
    //    主线程先休眠1秒，让terminate先执行，一秒钟足够terminate执行完毕，然后线程就结束了
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("terminate当前的线程状态="+terminate.getState());
        System.exit(1);
    }
}