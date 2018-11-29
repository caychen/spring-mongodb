package org.com.cay.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Author:       Caychen
 * Class:        org.com.cay.spring.entity.Person
 * Date:         2018/11/29
 * Desc:
 */

@Data
@Document(collection = "person")
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    private Integer id;

    private String name;
}
