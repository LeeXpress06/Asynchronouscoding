package com.shiblee.Asynchronouscoding.Service;

import com.shiblee.Asynchronouscoding.Model.Author;
import com.shiblee.Asynchronouscoding.Model.Book;
import com.shiblee.Asynchronouscoding.Model.BookData;

public class BookDataService {
    BookService bookService = new BookService();
    AuthorService authorService = new AuthorService();

    // get book data by traditional means
    public BookData getBookInfoByid (long id ) {
        Book book = bookService.getBookbyId(id);
        Author author = authorService.getAuthorByid(id);
        return BookData.builder()
                .id(id)
                .name(book.getBookName())
                .authorName(author.getName())
                .genre(author.getBookName())
                .build();
    }

}
