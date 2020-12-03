package com.quakus.demo.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.quakus.demo.common.ResponseMessages;
import com.quakus.demo.exception.UserServiceException;
import com.quakus.demo.rs.model.User;


import javax.enterprise.context.ApplicationScoped;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


@ApplicationScoped
public class UserService {

    private final Map<String, User> userMap = new HashMap<>();

    ObjectMapper objectMapper = new ObjectMapper();

    private String getUserName(User user) {
        String firstName = user.getFirstName();
        String lastName = user.getLastName();
        return firstName.substring(0, 3) + lastName.substring(0, 3) + firstName.hashCode();
    }

    public User addUser(User user) {
        String userName = getUserName(user);
        if (!userMap.containsKey(userName)) {
            user.setUsername(userName);
            user.setUserActive(Boolean.TRUE);
            userMap.put(userName, user);
            return user;
        } else throw new UserServiceException(javax.ws.rs.core.Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), ResponseMessages.USER_ALREADY_PRESENT);
    }

    public User deleteUser(String userName) {
        if (userMap.containsKey(userName)) {
            User user = userMap.get(userName);
            userMap.remove(userName);
            return user;
        } else throw new UserServiceException(javax.ws.rs.core.Response.Status.BAD_REQUEST.getStatusCode(), ResponseMessages.USER_NOT_FOUND);
    }

    public User getUser(String userName) {
        if (userMap.containsKey(userName)) {
            return userMap.get(userName);
        } else throw new UserServiceException(javax.ws.rs.core.Response.Status.BAD_REQUEST.getStatusCode(), ResponseMessages.USER_NOT_FOUND);
    }


    public User updateUser(User user) {
        String userName = getUserName(user);
        if (userMap.containsKey(userName)) {
            userMap.put(userName, user);
            return userMap.get(userName);
        } else throw new UserServiceException(javax.ws.rs.core.Response.Status.BAD_REQUEST.getStatusCode(), ResponseMessages.USER_NOT_FOUND);
    }

    public Collection<User> getUsers() {
        return userMap.values();
    }

}
