package com.muazhari.findcomputerws.services;

import com.muazhari.findcomputerws.dao.ItemDao;
import com.muazhari.findcomputerws.dao.UserDao;
import com.muazhari.findcomputerws.dao.UserItemLinkDao;
import com.muazhari.findcomputerws.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    private final UserItemLinkDao userItemLinkDao;
    private final UserDao userDao;
    private final ItemDao itemDao;

    @Autowired
    public UserService(
            @Qualifier("UserItemLink") UserItemLinkDao userItemLinkDao,
            @Qualifier("User") UserDao userDao,
            @Qualifier("Item") ItemDao itemDao) {
        this.userItemLinkDao = userItemLinkDao;
        this.userDao = userDao;
        this.itemDao = itemDao;
    }

    public User create(User user) {
        return userDao.create(new User(UUID.randomUUID(), user.getUsername(), user.getPassword(), user.getPassword()));
    }

    public List<User> getAll() {
        return userDao.getAll();
    }

    public User getById(UUID userId) {
        return userDao.getById(userId);
    }

    public Integer updateById(UUID userId, User userToUpdate) {
        return userDao.updateById(userId, userToUpdate);
    }

    public Integer deleteById(UUID userId) {
        return userDao.deleteById(userId);
    }

    public Integer updateByUsername(String username, User userToUpdate) {
        return userDao.updateByUsername(username, userToUpdate);
    }

    public Integer updateByUsernameAndPassword(String username, User userToUpdate) {
        return userDao.updateByUsernameAndPassword(username, userToUpdate);
    }

    public User getByUsername(String username) {
        return userDao.getByUsername(username);
    }
}
