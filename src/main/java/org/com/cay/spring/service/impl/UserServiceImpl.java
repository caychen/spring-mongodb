package org.com.cay.spring.service.impl;

import org.com.cay.spring.dao.IUserDao;
import org.com.cay.spring.entity.User;
import org.com.cay.spring.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Author:       Caychen
 * Class:        org.com.cay.spring.service.impl.UserServiceImpl
 * Date:         2018/11/28
 * Desc:
 */

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDao userRepository;

    @Override
    @Transactional
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> searchByName(String name) {
        return userRepository.searchByName(name);
    }

    @Override
    public List<User> searchByAge(Integer minAge, Integer maxAge) {
        return userRepository.searchByAge(minAge, maxAge);
    }

    @Override
    public List<User> searchByRegex(String nameRegex) {
        return userRepository.searchByRegex(nameRegex);
    }
}
