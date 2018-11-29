package org.com.cay.spring.dao;

import org.com.cay.spring.entity.User;

import java.util.List;

/**
 * Author:       Caychen
 * Interface:    org.com.cay.spring.dao.IUserDao
 * Date:         2018/11/28
 * Desc:
 */

public interface IUserDao {
    User save(User user);

    List<User> searchByName(String name);

    List<User> searchByAge(Integer minAge, Integer maxAge);

    List<User> searchByRegex(String nameRegex);
}
