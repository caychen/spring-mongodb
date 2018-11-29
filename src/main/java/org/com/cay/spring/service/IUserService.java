package org.com.cay.spring.service;

import org.com.cay.spring.entity.User;

import java.util.List;

/**
 * Author:       Caychen
 * Interface:    org.com.cay.spring.service.IUserService
 * Date:         2018/11/28
 * Desc:
 */

public interface IUserService {

    User save(User user);

    List<User> searchByName(String name);

    List<User> searchByAge(Integer minAge, Integer maxAge);

    List<User> searchByRegex(String nameRegex);
}
