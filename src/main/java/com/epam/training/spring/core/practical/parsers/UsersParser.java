package com.epam.training.spring.core.practical.parsers;

import com.epam.training.spring.core.practical.basic.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UsersParser {
    public static List<User> getUserList(String data)
            throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        List<User> users = new ArrayList();
        if (!data.isEmpty()) {
            users = mapper.readValue(data,
                    TypeFactory.defaultInstance()
                            .constructCollectionType(
                                    List.class,
                                    User.class));
        }
        return users;
    }
}
