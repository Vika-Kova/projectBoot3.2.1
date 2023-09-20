package ru.com.springdemo.projectBoot.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.com.springdemo.projectBoot.dao.UserDao;
import ru.com.springdemo.projectBoot.model.User;
import ru.com.springdemo.projectBoot.service.UserService;


@Controller
@RequestMapping("/")//url
public class UsersController {
    private final UserService userService;

    @Autowired
    public UsersController(UserDao userDao, UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String indexUser(Model model) {
        model.addAttribute("users", userService.indexUser());
        return "users/index";
    }

    @GetMapping("users/{id}")//адреса для строки
    public String showUser(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.showUser(id));// userService.showUser(id));
        return "users/show";

    }

    @GetMapping("users/new")
    public String newUser(@ModelAttribute("user") User user) {
        return "users/new";
    }

    @PostMapping("/users")
    public String createUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/";
    }

    @GetMapping("users/{id}/edit")
    public String editUser(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", userService.showUser(id));
        return "users/edit";
    }

    @PatchMapping("users/{id}")
    public String updateUser(@ModelAttribute("user") User user, @PathVariable("id") int id) {
        userService.updateUser(id, user);
        return "redirect:/";
    }

    @DeleteMapping("users/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        userService.deleteUser(id);
        return "redirect:/";
    }
}
