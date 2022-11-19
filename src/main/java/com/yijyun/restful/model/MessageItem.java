package com.yijyun.restful.model;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@Document("message")
public class MessageItem {

    @Id
    private String id;

    private String userId;
    private String text;

    private String timestamp;

    public MessageItem(String userId, String text,String timestamp) {
        this.userId = userId;
        this.text = text;
        this.timestamp = timestamp;
    }
}
