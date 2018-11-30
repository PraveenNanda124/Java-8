package code_00_thread.threadSynchronization;

/**
 * Created by 18351 on 2018/11/30.
 */
public class SellTicket3 implements Runnable{
    private int tickets = 100; //这一百张票是线程的共有资源

    //创建锁对象
    private Object obj = new Object();

    @Override
    public void run() {
        // 是为了模拟一直有票
        while (true) {
          sellTcicket();
        }
    }

    //锁对象是当前对象
    private synchronized void sellTcicket(){
        if (tickets > 0) {
            // 为了模拟更真实的场景，我们稍作休息
            try {
                Thread.sleep(100); //t1进来了并休息，t2进来了并休息，t3进来了并休息，
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "正在出售第" + (tickets--) + "张票");
        }
    }
}
