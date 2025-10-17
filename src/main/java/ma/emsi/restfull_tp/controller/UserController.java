package ma.emsi.restfull_tp.controller;


import ma.emsi.restfull_tp.model.User;
import ma.emsi.restfull_tp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // GET one user by ID
    @GetMapping("/user/{id}")
    public User getUser(@PathVariable("id") Integer id) {
        return userService.getUser(id);
    }

    // GET all users
    @GetMapping("/users")
    public List<User> getUsers() {
        return userService.getUsers();
    }

    // POST - add new user
    @PostMapping("/add")
    public String addUtilisateur(@RequestBody User user) {
        return userService.addUser(user);
    }

    // PUT - update existing user
    @PutMapping("/update/{id}")
    public String updateUser(@PathVariable("id") int id, @RequestBody User user) {
        return userService.updateUser(id, user);
    }

    // DELETE - delete user by id (using request param)
    @DeleteMapping("/supp")
    public void supprimerUser(@RequestParam("id") Integer id) {
        userService.suppUser(id);
    }
}
