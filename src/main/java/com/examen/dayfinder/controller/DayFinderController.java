package com.examen.dayfinder.controller;

import com.examen.dayfinder.entity.DayOfWeekResponse;
import com.examen.dayfinder.entity.Historique;
import com.examen.dayfinder.entity.SearchItems;
import com.examen.dayfinder.service.HistoriqueService;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DayFinderController {

    private final HistoriqueService historiqueService;

    @Autowired
    public DayFinderController(HistoriqueService historiqueService) {
        this.historiqueService = historiqueService;
    }

    @GetMapping("/services/calendar/dayfinder")
    public DayOfWeekResponse findDayOfWeek(@RequestParam String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate localDate = LocalDate.parse(date, formatter);
        DayOfWeek dayOfWeek = localDate.getDayOfWeek();
        DayOfWeekResponse dayOfWeekResponsenew = new DayOfWeekResponse(date, dayOfWeek.toString());
        SearchItems searchItems = new SearchItems(dayOfWeek.toString(), dayOfWeekResponsenew);
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String formattedDateTime = currentDateTime.format(formatter2);
        Historique h = new Historique(formattedDateTime, searchItems);
        historiqueService.create(h);
        return dayOfWeekResponsenew;
    }

    @GetMapping("/historique/all")
    public List<Historique> findAllHistorique() {
        return historiqueService.findAll();
    }
}
