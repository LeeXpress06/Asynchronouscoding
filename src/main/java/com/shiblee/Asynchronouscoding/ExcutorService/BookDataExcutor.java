package com.shiblee.Asynchronouscoding.ExcutorService;

import com.shiblee.Asynchronouscoding.Model.Author;
import com.shiblee.Asynchronouscoding.Model.Book;
import com.shiblee.Asynchronouscoding.Model.BookData;
import com.shiblee.Asynchronouscoding.Service.AuthorService;
import com.shiblee.Asynchronouscoding.Service.BookService;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;

public class BookDataExcutor {
    private long id;
    BookService bookService = new BookService();
    AuthorService authorService = new AuthorService();
    public BookDataExcutor(long id)  {
        this.id = id;
    }
    static ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime()
            .availableProcessors()) ;

    public static ExecutorService getExecutorService() {
        return executorService;
    }

    public BookData getbookdata(long id) throws ExecutionException, InterruptedException {

        Future<Book> bookfuture = executorService.submit(( )-> bookService.getBookbyId(id));
        Future<Author> authorfuture = executorService.submit(( ) -> authorService.getAuthorByid(id));
        Book book = bookfuture.get();
        Author author = authorfuture.get();
        return BookData.builder()
                .id(id)
                .name(book.getBookName())
                .authorName(author.getName())
                .genre(book.getGenre())
                .build();
    }
}
