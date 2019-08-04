package Library;
/*
借书还书的共享资源--书的数目和两个线程的run方法
 */
public class Books {
    private int bookNumber = 1;
    private boolean flag = false;
    Object obj = new Object();
    public void returnBooks(){
        while (true) {
            synchronized (obj) {
                try {
                    Thread.sleep(0);
                } catch (InterruptedException e) {
                }
                System.out.println("还书一本，现有库存：" + (++bookNumber));
                if (bookNumber == 3){ //终止线程
                    System.out.println("库存已满，退出程序");
                    System.exit(-1);
                }
                if(flag){ //无库存还书后令借书线程继续执行
                    flag = false;
                    super.notifyAll();
                }
            }
        }
    } //还书的run方法
    public void borrowBooks(){
        while (true) {
            synchronized (obj) {
                if (bookNumber == 0){ //无库存时等待还书过程
                    flag = true;
                    try{
                        super.wait();
                    } catch (InterruptedException e){}
                }
                try {
                    Thread.sleep(0);
                } catch (InterruptedException e) {
                }
                System.out.println("借书一本，现有库存：" + (--bookNumber));
                if (bookNumber == 0){
                    System.out.println("暂无库存，等待还书");
                }
            }
        }
    } //借书的run方法
}
