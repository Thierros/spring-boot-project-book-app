package com.esi.bookapp.EsiBookApp.controller;

import com.esi.bookapp.EsiBookApp.model.Book;
import com.esi.bookapp.EsiBookApp.service.BookService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/*
 * La couche Controller:  gere les interaction en renvoyant les donnees correspondantes a chaque requete
 * */

@RestController
@Data
public class BookController {

    @Autowired
    private BookService bs;

    @GetMapping("/")
    public ModelAndView home(Model model){
        List<Book> listBook=bs.getBooks();
        model.addAttribute("book",listBook);
        return new ModelAndView ("index");
    }

    @GetMapping("/books")
    public List<Book> getBooks(){
        return bs.getBooks();
    }

    @GetMapping("/create")
    public ModelAndView createBook(){
//        ajouter le code qu'il faut: recuperer les donnees du formulaire puis cree un Book et le stocker dans la base de donees
        return new ModelAndView ("create");
    }

    @GetMapping("/edite/{id}")
    public void editBook(@PathVariable("id") int id){
//        utiliser l'id pour editer le Book selectionner
    }

    @GetMapping("/delete/{id}")
    public void deleteBook(@PathVariable("id") int id){
        bs.deleteBook(id);
    }
}
