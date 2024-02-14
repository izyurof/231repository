package web.controller;

import hibernate.model.User;
import hibernate.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class UserController {

    private final UserService USER_SERVICE;
    public UserController(UserService USER_SERVICE) {
        this.USER_SERVICE = USER_SERVICE;
    }

    @GetMapping("/users")
    public String showAllUsers(Model model) {
        List<User> allUsers = USER_SERVICE.getAllUsers();
        model.addAttribute("allUsers", allUsers);
        return "show";
    }

    @GetMapping("/users/adding")
    public String addUser(Model model) {
        model.addAttribute("user", new User());
        return "adduser";
    }

    @PostMapping("/users")
    public String addUser(@ModelAttribute(value = "user") User user) {
        USER_SERVICE.saveUser(user);

        return "redirect:/users";
    }

    @GetMapping("/users/updateuser")
    public String updateUser(@RequestParam(value = "id") Long id, Model model) {
        User user = USER_SERVICE.findUserById(id);
        model.addAttribute("userupdate", user);
        return "updateuser";
    }

    @PostMapping("/users/updateuser")
    public String updateUser(@ModelAttribute(value = "userupdate") User user) {
        USER_SERVICE.updateUser(user);
        return "redirect:/users";
    }

    @GetMapping("/users/deleteuser")
    public String deleteUser(@RequestParam(value = "id") Long id, Model model) {
        User user = USER_SERVICE.findUserById(id);
        model.addAttribute("deleteuser", user);
        return "deleteuser";
    }

    @PostMapping("/users/deleteuser")
    public String deleteUser(@ModelAttribute(value = "deleteuser") User user) {
        System.out.println(user.getId());
        USER_SERVICE.deleteUser(user);
        return "redirect:/users";
    }


}
