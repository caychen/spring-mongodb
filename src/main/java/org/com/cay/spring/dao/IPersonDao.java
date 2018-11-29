package org.com.cay.spring.dao;

import org.com.cay.spring.entity.Person;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Author:       Caychen
 * Interface:    org.com.cay.spring.dao.IPersonDao
 * Date:         2018/11/29
 * Desc:
 */

public interface IPersonDao extends MongoRepository<Person, Integer> {
}
