package com.epam.training.spring.core.practical.controllers;

import com.epam.training.spring.core.practical.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

@Controller
@RequestMapping(value = {"/user"})
public class UserController {
    private final String ALL_USER = "allUser";
    private final String USER_ABOUT = "userAbout";
    @Autowired
            @Qualifier("userService")
    UserService userService;

//    @RequestMapping(method = RequestMethod.GET)
//    public ModelAndView getAll() {
//        modelMap.addAttribute("user", userService.getAll());
//        return ALL_USER;
//    }

    @RequestMapping(value = USER_ABOUT, method = RequestMethod.GET)
    public ModelAndView getUserByEmail(/*String email*/) {
        return new ModelAndView("user/userAbout", "user", userService.getUserByEmail("b@epam.com"));
    }
}
