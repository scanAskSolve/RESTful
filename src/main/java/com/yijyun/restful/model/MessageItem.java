package com.yijyun.restful.model;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("message")
public class MessageItem {

    @Id
    private String id;

    private String userId;
    private String text;

    public MessageItem(String userId, String text) {
        this.userId = userId;
        this.text = text;
    }
}
