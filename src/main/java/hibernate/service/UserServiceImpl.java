package hibernate.service;

import hibernate.DAO.UserDao;
import hibernate.model.User;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao USER_DAO;

    public UserServiceImpl(UserDao userDao) {
        this.USER_DAO = userDao;
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        USER_DAO.saveUser(user);
    }

    @Override
    @Transactional(readOnly = true)
    public User findUserById(Long id) {
        return USER_DAO.findUserById(id);
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        USER_DAO.updateUser(user);
    }

    @Override
    @Transactional
    public void deleteUser(User user) {
        USER_DAO.deleteUser(user);
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
        return USER_DAO.getAllUsers();
    }
}
