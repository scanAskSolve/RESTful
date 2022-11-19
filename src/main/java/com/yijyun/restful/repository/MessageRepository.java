package com.yijyun.restful.repository;

import com.yijyun.restful.model.MessageItem;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface MessageRepository extends MongoRepository<MessageItem, String> {
    @Aggregation(pipeline = {
            "{ '$match': { 'userId' : ?0 } }",
            "{ '$sort' : { '_id' : -1 } }",
            "{ '$limit' : ?1 }"
    })
    List<MessageItem> findMessageItemByUserId(String userId, int limit);

}