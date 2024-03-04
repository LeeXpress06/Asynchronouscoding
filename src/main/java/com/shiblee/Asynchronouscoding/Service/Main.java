package com.shiblee.Asynchronouscoding.Service;

import com.shiblee.Asynchronouscoding.ExcutorService.BookDataExcutor;
import com.shiblee.Asynchronouscoding.Model.BookData;
import com.shiblee.Asynchronouscoding.Thread.BookDataThread;

import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
//        BookDataThread bookDataThread = new BookDataThread();
//        BookData bookData = bookDataThread.getBookDataThread(1);
//        System.out.println(bookData);
//        BookDataService bookDataService = new BookDataService();
//       BookData bookData = bookDataService.getBookInfoByid(1);
//        System.out.println(bookData);

        BookDataExcutor bookDataExcutor = new BookDataExcutor(1);

       BookData bookData = bookDataExcutor.getbookdata(1);
        System.out.println(bookData);

        BookDataExcutor.getExecutorService().shutdown();



    }
}
