package com.esi.bookapp.EsiBookApp.repository;

import com.esi.bookapp.EsiBookApp.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
/*
    la couche epository: interface d'acces au donnees, utilise JPA
*/
public interface BookRepository extends JpaRepository<Book, Integer> {
}
