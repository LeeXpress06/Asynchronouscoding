package com.shiblee.Asynchronouscoding.Service;

import com.shiblee.Asynchronouscoding.Model.Book;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@NoArgsConstructor
public class BookService {
    List<Book> booklist = Arrays.asList(new Book(1,"AntiFragile","Non-Fiction"),
            new Book(2,"Black Swan","history"), new Book(3,"thinking fast",
                    "psychology"));
    public Book getBookbyId(long bookId ){
        Book book = booklist.stream().filter(
                s -> s.getBookId() == bookId
        ).findFirst().get();
        return book;
    }


}
