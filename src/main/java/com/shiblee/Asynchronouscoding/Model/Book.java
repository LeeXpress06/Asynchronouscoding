package com.shiblee.Asynchronouscoding.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    private long bookId;
    private String bookName;
    private String genre;
    public Book getbookById( long bookId){
        return new Book(bookId,bookName,genre);
    }
}
