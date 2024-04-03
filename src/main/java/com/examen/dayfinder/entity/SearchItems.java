package com.examen.dayfinder.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class SearchItems {

    private String request;
    private DayOfWeekResponse response;

    public SearchItems(String request, DayOfWeekResponse response) {
        this.request = request;
        this.response = response;
    }
}
