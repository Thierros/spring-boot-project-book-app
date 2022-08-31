package com.esi.bookapp.EsiBookApp.model;

import lombok.Data;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;

/*
* Le model: design le modele de donnee de notre application
* */

@Data
@Entity
@Table(name = "books")
public class Book {

    @Id
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "author")
    private String author;

    @Column(name = "quantity")
    private int quantity;
}
