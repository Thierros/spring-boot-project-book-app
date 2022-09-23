package com.esi.bookapp.EsiBookApp.service;

import com.esi.bookapp.EsiBookApp.model.Book;
import com.esi.bookapp.EsiBookApp.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Optional<Book> getBook(final int id){
        return br.findById(id);
    }

    public void deleteBook(int id){
        br.deleteById(id);
    }

    public void saveBook(Book book) {
        book.setTitle(book.getTitle().toUpperCase());
        br.save(book);
    }



}