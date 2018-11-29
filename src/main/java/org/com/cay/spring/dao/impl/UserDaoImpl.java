package org.com.cay.spring.dao.impl;

import org.com.cay.spring.dao.IUserDao;
import org.com.cay.spring.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Author:       Caychen
 * Class:        org.com.cay.spring.dao.impl.UserDaoImpl
 * Date:         2018/11/28
 * Desc:
 */

@Repository
public class UserDaoImpl implements IUserDao {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    @Transactional
    public User save(User user) {
        mongoTemplate.insert(user);
        return user;
    }

    @Override
    public List<User> searchByName(String name) {
        Query query = new Query();
        query.addCriteria(Criteria.where("name").is(name));
        return mongoTemplate.find(query, User.class);
    }

    @Override
    public List<User> searchByAge(Integer minAge, Integer maxAge) {
        Query query = new Query();
        query.addCriteria(Criteria.where("age").gte(minAge).lte(maxAge));
        return mongoTemplate.find(query, User.class);
    }

    @Override
    public List<User> searchByRegex(String nameRegex) {
        Query query = new Query();
        query.addCriteria(Criteria.where("name").regex(nameRegex));
        return mongoTemplate.find(query, User.class);
    }
}
