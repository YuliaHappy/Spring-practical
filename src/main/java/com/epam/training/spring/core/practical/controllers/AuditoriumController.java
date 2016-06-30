package com.epam.training.spring.core.practical.controllers;

import com.epam.training.spring.core.practical.basic.Auditorium;
import com.epam.training.spring.core.practical.services.AuditoriumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.expression.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;
import java.util.Random;

@Controller
@RequestMapping(value = {"/auditorium"})
public class AuditoriumController {
    private final String ALL_AUDITORIUM = "/allAuditoriums";
    private final String AUDITORIUM_ABOUT = "/auditoriumAbout";
    private final String AUDITORIUM_DELETE = "/auditoriumDelete";
    private final String AUDITORIUM_SAVE = "/auditoriumSave";
    private final String AUDITORIUM_PDF = "/pdfAuditoriums";

    @Autowired
    @Qualifier("auditoriumService")
    AuditoriumService auditoriumService;

    @RequestMapping(value = ALL_AUDITORIUM, method = RequestMethod.GET)
    public ModelAndView getAllAuditoriums() {
        return new ModelAndView("auditorium/allAuditoriums", "auditoriums", auditoriumService.getAuditoriums());
    }

    @RequestMapping(value = AUDITORIUM_ABOUT + "/{id}", method = RequestMethod.GET)
    public ModelAndView getAuditoriumById(@PathVariable(value = "id") int id) {
        return new ModelAndView("auditorium/auditoriumAbout", "auditorium", auditoriumService.getAuditoriumById(id));
    }

    @RequestMapping(value = AUDITORIUM_DELETE + "/{id}", method = RequestMethod.GET)
    public ModelAndView deleteAuditorium(@PathVariable(value = "id") int id) {
        auditoriumService.remove(id);
        return getAllAuditoriums();
    }

    @RequestMapping(value = AUDITORIUM_SAVE, method = RequestMethod.GET)
    public ModelAndView saveAuditorium() {
        return new ModelAndView("auditorium/addAuditorium");
    }

    @RequestMapping(value = AUDITORIUM_SAVE, method = RequestMethod.POST)
    public ModelAndView addUser(@RequestParam Map<String, String> parametrs) throws ParseException {
        auditoriumService.add(
                new Auditorium(new Random().nextInt(), parametrs.get("name"), new Integer(parametrs.get("countOfSeats"))));
        return getAllAuditoriums();
    }

    @RequestMapping(value = AUDITORIUM_PDF, method = RequestMethod.GET)
    public ModelAndView getAllUsersInPdf() {
        List<Auditorium> auditoriums = auditoriumService.getAuditoriums();
        return new ModelAndView("pdfViewAuditorium", "listAuditoriums", auditoriums);
    }
}
