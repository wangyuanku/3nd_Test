package Library;
/*
还书线程
 */
public class ReturnBooks implements Runnable {
    private Books books;
    public ReturnBooks(Books books){
        this.books = books;
    }
    public void run(){
        while (true){
            try {
                books.returnBooks();
            } catch (Exception e){}
        }
    }
}
