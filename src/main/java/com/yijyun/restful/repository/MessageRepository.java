package com.yijyun.restful.repository;

import com.yijyun.restful.model.MessageItem;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MessageRepository extends MongoRepository<MessageItem, String> {


}