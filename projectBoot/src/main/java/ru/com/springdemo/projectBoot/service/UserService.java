package ru.com.springdemo.projectBoot.service;


import ru.com.springdemo.projectBoot.model.User;

import java.util.List;

public interface UserService {
    void saveUser(User user);

    void updateUser(int id, User user);

    void deleteUser(int id);

    User showUser(int id);

    List<User> indexUser();
}


