package com.examen.dayfinder.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Historique")
public class Historique {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String searchDate;

    private SearchItems searchItems;

    public Historique(String searchDate, SearchItems searchItems) {
        this.searchDate = searchDate;
        this.searchItems = searchItems;
    }
}
