package Library;
/*
图书馆系统的运行
 */
public class LibrarySystem {
    public static void main(String[] args){
        Books books = new Books();
        ReturnBooks rb = new ReturnBooks(books);
        BorrowBooks bb = new BorrowBooks(books);
        Thread t1 = new Thread(rb);
        Thread t2 = new Thread(bb);

//        Thread t3 = new Thread(rb);
//        Thread t4 = new Thread(bb);

        System.out.println("现有库存：1本；已借出：2本");
//        t4.start();
        t2.start();
        t1.start();
//        t3.start();
    }
}
