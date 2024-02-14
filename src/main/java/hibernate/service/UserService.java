package hibernate.service;

import hibernate.model.User;

import java.util.List;

public interface UserService {
    void saveUser(User user);
    User findUserById(Long id);
    void updateUser(User user);
    void deleteUser(User user);
    List<User> getAllUsers();
}
