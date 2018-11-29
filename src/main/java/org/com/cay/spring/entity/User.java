package org.com.cay.spring.entity;

import lombok.Data;
import lombok.Value;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * Author:       Caychen
 * Class:        org.com.cay.spring.entity.User
 * Date:         2018/11/28
 * Desc:
 */
@Document(collection = "user")
@Data
public class User {

    @Id
    private String id;

    private String name;

    private Integer age;

    private String gender;

    private Double salary;

    private Date birthDate;
}
