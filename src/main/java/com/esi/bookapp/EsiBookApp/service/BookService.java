package com.esi.bookapp.EsiBookApp.service;

import com.esi.bookapp.EsiBookApp.model.Book;
import com.esi.bookapp.EsiBookApp.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*
* la couche Service: toute la logic du metier, les differents traitements doivent etre fait ici
* */

@Service
public class BookService {

    @Autowired
    private BookRepository br;

    public List<Book> getBooks(){
        return br.findAll();
    }
}
