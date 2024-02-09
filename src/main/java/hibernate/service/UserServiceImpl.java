package hibernate.service;

import hibernate.DAO.UserDao;
import hibernate.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    @Transactional
    public void saveUser(User user) {
        userDao.saveUser(user);
    }
}
