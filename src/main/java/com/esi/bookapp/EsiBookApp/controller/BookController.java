package com.esi.bookapp.EsiBookApp.controller;

import com.esi.bookapp.EsiBookApp.model.Book;
import com.esi.bookapp.EsiBookApp.service.BookService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/*
 * La couche Controller:  gere les interaction en renvoyant les donnees correspondantes a chaque requete
 * */

@RestController
@Data
public class BookController {

    @Autowired
    private BookService bs;

    @GetMapping("/books")
    public List<Book> getBooks(){
        return bs.getBooks();
    }
}
