package org.com.cay.spring;

import org.com.cay.spring.dao.IPersonDao;
import org.com.cay.spring.entity.Person;
import org.com.cay.spring.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Author:       Caychen
 * Class:        org.com.cay.spring.MongodbTest
 * Date:         2018/11/28
 * Desc:
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring/spring.xml"})
public class MongodbTest {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private IPersonDao personDao;

    @Test
    public void searchByName() {
        String name = "caychen";
        Query query = new Query();
        query.addCriteria(Criteria.where("name").is(name));
        List<User> users = mongoTemplate.find(query, User.class);
        System.out.println(users);
    }

    @Test
    public void searchByAge() {
        Integer minAge = 10, maxAge = 30;
        Query query = new Query();
        query.addCriteria(Criteria.where("age").gte(minAge).lte(maxAge));
        System.out.println(mongoTemplate.find(query, User.class));
    }

    @Test
    public void searchByRegex() {
        String nameRegex = "en";
        Query query = new Query();
        query.addCriteria(Criteria.where("name").regex(nameRegex));
        System.out.println(mongoTemplate.find(query, User.class));
    }

    @Test
    public void searchByAnd() {
        Query query = new Query();
        Criteria criteria = new Criteria();
        criteria.andOperator(Criteria.where("gender").is("0"), Criteria.where("age").gt(10).lt(30));
        query.addCriteria(criteria);
        System.out.println(mongoTemplate.find(query, User.class));
    }

    @Test
    public void searchPageLimit() {
        Query query = new Query();
        System.out.println(mongoTemplate.find(query.limit(1), User.class));
    }

    @Test
    public void searchPageSkip() {
        Query query = new Query();
        //limit:表示返回数
        //skip:跳过前N条数据
        System.out.println(mongoTemplate.find(query.limit(2).skip(1), User.class));
    }

    @Test
    public void update() {
        Query query = new Query();
        query.addCriteria(Criteria.where("name").is("tom"));

        Update update = Update.update("age", 30);
        mongoTemplate.updateFirst(query,update, User.class);
    }

    @Test
    public void testPersonDao(){
//        Person person = new Person(1, "caychen");
//        personDao.insert(person);

        Person one = personDao.findOne(1);
        System.out.println(one);
    }
}
