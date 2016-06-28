package com.epam.training.spring.core.practical.controllers;

import com.epam.training.spring.core.practical.controllers.services.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Map;

@Controller
@RequestMapping(value = {"/saveJson"})
public class FileController {
    @Autowired
    private FileService fileService;

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView addUserFromJson(HttpServletRequest req) throws IOException {
        MultipartHttpServletRequest request = (MultipartHttpServletRequest) req;
        Map<String, MultipartFile> files = request.getFileMap();
        if (!files.isEmpty()) {
            fileService.parseFiles(files);
        }
        return new ModelAndView("redirect:/user/allUsers");
    }
}
