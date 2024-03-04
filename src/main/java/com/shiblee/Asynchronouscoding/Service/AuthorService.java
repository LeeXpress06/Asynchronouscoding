package com.shiblee.Asynchronouscoding.Service;

import com.shiblee.Asynchronouscoding.Model.Author;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.List;

@NoArgsConstructor
public class AuthorService {
       List<Author> authors = Arrays.asList(
               new Author(1,"shiblee","Black Swan"),
               new Author(2,"Nassim Taleb","AntiFragile")
       );

       public Author getAuthorByid( long id ){

           return authors.stream().filter(
                   author -> author.getBookNo() == id
           ).findFirst().get();

       }
}
