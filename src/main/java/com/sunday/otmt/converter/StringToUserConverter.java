package com.sunday.otmt.converter;

import com.sunday.otmt.entity.User;
import com.sunday.otmt.exception.EntityNotFoundException;
import com.sunday.otmt.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToUserConverter implements Converter<String, User> {

    @Autowired
    private GenericService<User> userService;

    /**
     * By using given username in request,
     * it returns the user that username belongs to.
     * @param userName
     * @return the user that has the username.
     */
    @Override
    public User convert(String userName) {
        try {
            return userService.getByName(userName);
        } catch (EntityNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

}