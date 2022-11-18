package com.yijyun.restful.service;

import com.yijyun.restful.model.GroceryItem;
import com.yijyun.restful.repository.ItemRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
@Slf4j
public class MongoService {

    @Autowired
    ItemRepository itemRepository;

    @PostConstruct
    void init(){
        GroceryItem groceryItem = new GroceryItem("EG",12,"message");
        itemRepository.insert(groceryItem);
    }
}
