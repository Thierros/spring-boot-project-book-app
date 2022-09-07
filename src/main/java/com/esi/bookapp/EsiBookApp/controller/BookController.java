package com.esi.bookapp.EsiBookApp.controller;

import com.esi.bookapp.EsiBookApp.model.Book;
import com.esi.bookapp.EsiBookApp.service.BookService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping("/create")
    public ModelAndView createBook(Model model){
        Book book = new Book();
        model.addAttribute("book", book);
        return new ModelAndView("create");
    }

    @PostMapping("/saveBook")
    public ModelAndView saveBook(@ModelAttribute Book b){
//        System.out.println(b.toString());
        bs.saveBook(b);
        return new ModelAndView("redirect:/");
    }

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

    @GetMapping("/edite/{id}")
    public ModelAndView editBook(@PathVariable("id") int id){
//        utiliser l'id pour editer le Book selectionner
        return new ModelAndView("create");
    }

    @GetMapping("/delete/{id}")
    public ModelAndView deleteBook(@PathVariable("id") int id){
        bs.deleteBook(id);
        return new ModelAndView("redirect:/");
    }
}
