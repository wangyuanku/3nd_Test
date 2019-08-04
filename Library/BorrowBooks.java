package Library;
/*
借书线程
 */
public class BorrowBooks  implements Runnable{
    private Books books;
    public BorrowBooks(Books books){
        this.books = books;
    }
    public void run(){
        while (true){
            try {
                books.borrowBooks();
            } catch (Exception e){}
        }
    }
}
