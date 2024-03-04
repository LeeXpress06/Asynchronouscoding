package com.shiblee.Asynchronouscoding.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookData {

    private long id;
    private String name;
    private String authorName;
    private String genre;




}
