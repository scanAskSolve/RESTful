package com.yijyun.restful.service;

import com.yijyun.restful.pojo.ro.WebhookRo;
import com.yijyun.restful.repository.ItemRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class LineService {

    @Autowired
    ItemRepository itemRepository;
    public void lineEvent(WebhookRo webhookRo) {
        System.out.println(webhookRo.getEvents());
//        for (WebhookRo.EventsDTO eventsDTO : webhookRo.getEvents()) {
//            if (Objects.equals(eventsDTO.getType(), "message")) {
//                MessageItem messageItem = new MessageItem(eventsDTO.getSource().getUserId(),eventsDTO.getMessage().getText());
//                itemRepository.insert(messageItem);
//            }
//        }

    }
}
