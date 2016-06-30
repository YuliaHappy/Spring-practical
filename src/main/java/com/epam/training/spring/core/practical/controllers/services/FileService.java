package com.epam.training.spring.core.practical.controllers.services;

import com.epam.training.spring.core.practical.parsers.Converter;
import com.epam.training.spring.core.practical.parsers.UsersParser;
import com.epam.training.spring.core.practical.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@Service
public class FileService {
    private final String USERS_NAME = "users";
    @Autowired
    private UserService userService;

    public void parseFiles(Map<String, MultipartFile> files)
            throws IOException {
        for (String key :
                files.keySet()) {
            if (key.equals(USERS_NAME)) {
                String data = Converter.read(files.get(key).getInputStream());
                userService.registerUsers(UsersParser.getUserList(data));
            }
        }
    }
}
