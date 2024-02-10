package hibernate.service;

import hibernate.model.User;

public interface UserService {
    public void saveUser(User user);
    public User findUserById(Integer id);
    public void updateUser(User user);
    public void deleteUser(User user);
}
