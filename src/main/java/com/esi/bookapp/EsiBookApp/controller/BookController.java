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
import java.util.Optional;

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
    
      @PutMapping("/book/{id}")
    public Book updateBook(@PathVariable("id") int id, @RequestBody Book book) {
        Optional<Book> b = bs.getBook(id);
        if(e.isPresent()) {
            Book currentBook = e.get();

            String title = book.getTitle();
            if(title != null) {
                currentBook.setTitle(title);
            }
            String author = book.getAuthor();
            if(author != null) {
                currentBook.setAuthor(author);
            }
            int quantity = book.getQuantity();
            if(quantity != 0) {
                currentBook.setQuantity(quantity);
            }
            bs.saveBook(currentBook);
            return currentBook;
        } else {
            return null;
        }
    }


    @GetMapping("/delete/{id}")
    public ModelAndView deleteBook(@PathVariable("id") int id){
        bs.deleteBook(id);
        return new ModelAndView("redirect:/");
    }
}
