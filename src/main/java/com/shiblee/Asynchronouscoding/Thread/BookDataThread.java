package com.shiblee.Asynchronouscoding.Thread;

import com.shiblee.Asynchronouscoding.Model.Author;
import com.shiblee.Asynchronouscoding.Model.Book;
import com.shiblee.Asynchronouscoding.Model.BookData;
import com.shiblee.Asynchronouscoding.Service.AuthorService;
import com.shiblee.Asynchronouscoding.Service.BookService;

public class BookDataThread {

    // first get the service class
    BookService bookService = new BookService();
    AuthorService authorService = new AuthorService();

    // method to use data
    public BookData getBookDataThread(long id) throws InterruptedException {

    // now the work of  service class is  offloaded to runnable interface
    BookRunnable bookRunnable = new BookRunnable(id);
    AuthorRunnable authorRunnable = new AuthorRunnable(id);
    //Let create task
    Thread bookthread = new Thread(bookRunnable);
    Thread authorthread = new Thread(authorRunnable);

    // start the thread
        bookthread.start();
        authorthread.start();

     // they will join the thread
      bookthread.join();
      authorthread.join();

        // now time extract the result
        Book book = bookRunnable.getBook();
        Author author = authorRunnable.getAuthor();

        return BookData.builder()
                .id(id)
                .name(book.getBookName())
                .authorName(author.getName())
                .genre(book.getGenre())
                .build();

}
    public class BookRunnable implements Runnable{
        // as runnable does not get any parameter so declairing local variable to inject data and get method to get data
        private long id;
        private Book book;
        public BookRunnable(long id) {
            this.id = id;
        }
        // get method to get data
        public Book getBook() {
            return book;
        }

        @Override
        public void run() {
             book = bookService.getBookbyId(id);
        }

    }
     // another inner class

    public class AuthorRunnable implements Runnable{
        private long id;
        private Author author;
        public AuthorRunnable(long id) {
            this.id = id;
        }
        // get the author data and pass it into the thread
        public Author getAuthor() {
            return author;
        }
        @Override
        public void run() {
          author =   authorService.getAuthorByid(id);

        }
    }
}
