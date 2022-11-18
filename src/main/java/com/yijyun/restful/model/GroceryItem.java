package com.yijyun.restful.model;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("user")
public class GroceryItem {

    @Id
    private String id;

    private String name;
    private int age;
    private String message;

    public GroceryItem(String name, int age, String message) {
        this.name = name;
        this.age = age;
        this.message = message;
    }
}
