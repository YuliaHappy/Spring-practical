package com.epam.training.spring.core.practical.controllers;

import com.epam.training.spring.core.practical.basic.User;
import com.epam.training.spring.core.practical.controllers.forms.UserForm;
import com.epam.training.spring.core.practical.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping(value = {"/user"})
public class UserController {
    private final String ALL_USER = "/allUsers";
    private final String USER_ABOUT = "/userAbout";
    private final String USER_DELETE = "/userDelete";
    private final String USER_SAVE = "/userSave";
    private final String USER_PDF = "/pdfUsers";

    @Autowired
    @Qualifier("userService")
    UserService userService;

//    @RequestMapping(value = USER_ABOUT + "/{email}/", method = RequestMethod.GET)
//    public ModelAndView getUserByEmail(@PathVariable(value = "email") String email) {
//        return new ModelAndView("user/userAbout", "user", userService.getUserByEmail(email));
//    }

    @RequestMapping(value = ALL_USER, method = RequestMethod.GET)
    public ModelAndView getAllUsers() {
        return new ModelAndView("user/allUsers", "users", userService.getAll());
    }

    @RequestMapping(value = USER_ABOUT + "/{id}", method = RequestMethod.GET)
    public ModelAndView getUserById(@PathVariable(value = "id") int id) {
        return new ModelAndView("user/userAbout", "user", userService.getById(id));
    }

    @RequestMapping(value = USER_DELETE + "/{id}", method = RequestMethod.GET)
    public ModelAndView deleteUser(@PathVariable(value = "id") int id) {
        userService.remove(id);
        return getAllUsers();
    }

    @RequestMapping(value = USER_SAVE, method = RequestMethod.GET)
    public ModelAndView saveUser() {
        return new ModelAndView("user/addUser");
    }

    @RequestMapping(value = USER_SAVE, method = RequestMethod.POST)
    public ModelAndView addUser(@RequestParam Map<String, String> parametrs) throws ParseException {
        userService.register(
                new User(new Random().nextInt(), parametrs.get("name"), parametrs.get("email"),
                        new SimpleDateFormat("yyyy-MM-dd").parse(parametrs.get("birthday"))));
        return getAllUsers();
    }

    @RequestMapping(value = USER_PDF, method = RequestMethod.GET)
    public ModelAndView getAllUsersInPdf() {
        List<User> users = userService.getAll();
        return new ModelAndView("pdfView", "listUsers", users);
    }
}
